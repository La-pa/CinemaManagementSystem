<template>
  <div class = "all">
      <el-container>
          <el-aside width="130px"></el-aside>
          <el-container>
              <el-header>
                  <div class="header-content">
                      <el-breadcrumb separator-class="el-icon-arrow-right" class="bread">                      
                          <el-breadcrumb-item ><i class="el-icon-arrow-left" style="font-size:30px;color:rgb(255,255,255)" @click="ComeBack"></i></el-breadcrumb-item>
                          <el-breadcrumb-item ><div style="font-size: 26px;margin-left: 400px;">国际影城</div></el-breadcrumb-item>
                      </el-breadcrumb>
                  </div>
              </el-header>
              <el-main>
                <div style="width:100%;background-color:#bfa;height:50px; display: flex; justify-content: flex-start; align-items: center; margin-top:-20px">
                  <el-tooltip :content="description" placement="bottom" effect="light">
                    <p style="color:yellowgreen;font-size: 20px;">{{ title }}</p>
                  </el-tooltip>
                </div>
                <div style="display: flex;">
                  <div class="seat-map" style="flex;margin-left: 20%;">
                    <div v-for="(row, rowIndex) in seatMap" :key="rowIndex" class="seat-row">
                      <div v-for="(seat, seatIndex) in row" :key="seatIndex" class="seat" :class="{ selected: seat.selected, disabled: seat.disabled }" @click="toggleSeat(seat)">
                      </div>
                    </div>
                  </div>
                  <div class="booking-form" style="flex:1;margin-top:60px;" >
                    <el-form :model="form" style="width:90%">
                      <el-form-item>
                        <el-date-picker v-model="form.date" type="date" placeholder="请选择日期" :picker-options="pickerOptions" value-format="yyyy-MM-dd"></el-date-picker>
                      </el-form-item>
                      <el-form-item >
                        <el-select v-model="form.hall" placeholder="请选择放映厅" :clearable="true" >
                          <el-option
                            v-for="showTime in filteredShowTimes"
                            :key="showTime.roomId"
                            :label="showTime.roomId+'号放映厅'"
                            :value="showTime.roomId"
                          ></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item >
                        <el-select v-model="form.time" placeholder="请选择时间段">
                          <el-option
                            v-for="time in filteredTimes"
                            :key="time"
                            :label="getTimeSegment(time)"
                            :value="time"
                          ></el-option>
                        </el-select>
                      </el-form-item>
                    </el-form>
                 </div>
                 </div>
                  <div v-if="showConfirmation" class="confirmation">
                    <p>你已选中以下座位：</p>
                    <ul class="ulMessage">
                      <li class = "liMessage" v-for="(seat, index) in selectedSeats" :key="index">{{seat.seatRow}}排{{seat.seatCol}}座</li>
                    </ul>
                    <span>
                      <el-button round class="confirm-button" @click="confirmSelection" type="primary" size="small">提交订单</el-button>
                      <el-button round class="cancel-button" @click="cancelSelection" type="primary" size="small">取消选座</el-button>
                    </span>
                  </div>
              </el-main>
              <el-footer></el-footer>
          </el-container>
          <el-aside width="130px"></el-aside>
      </el-container>
  </div>
</template>
<script>
import MovieData from './MovieData.vue';

  
    const availableDates = []; 
  
    export default{
  
      watch: {
        'form.hall': {
              handler(newValue) {
              this.filteredTimes = this.filteredShowTimes.map(showTime => showTime.startTime);
              this.form.time = ''; // 清空已选择的时间段
              this.fetchSeatStatus(); // 查询座位状态
              this.availableDates = []; 
              this.showTimes.forEach(showTime => {
                const startDate = showTime.startTime.split(' ')[0]; // 提取年月日部分
                if (!this.availableDates.includes(startDate)) {
                  this.availableDates.push(startDate);
                }
              });
                        },
          },
          'form.date': {
              handler(newValue) {
              this.form.hall = ''; // 将放映厅重置为空
              this.form.time = ''; // 将时间段重置为空
              this.fetchSeatStatus(); // 查询座位状态
              this.availableDates = [];
              this.showTimes.forEach(showTime => {
                const startDate = showTime.startTime.split(' ')[0]; // 提取年月日部分
                if (!this.availableDates.includes(startDate)) {
                  this.availableDates.push(startDate);
                }
              });
                        },
          },
          'form.time': {
              handler(newValue) {
              this.fetchSeatStatus();
              
              },
          },
      },
      data(){
        return{
          // availableDates:[],
          filteredTimes: [],
          pickerOptions:{
            disabledDate(date) {
              const year = date.getFullYear();
              const month = date.getMonth() + 1;
              const day = date.getDate();
              const selectedDate = `${year}-${month < 10 ? '0' + month : month}-${day < 10 ? '0' + day : day}`;
              return !availableDates.includes(selectedDate);
            },
          },
          id:'',
          title:'',
          description:'',
          seatMap: [
            [{ seatRow:'A',seatCol:1,selected: false, disabled: false }, { seatRow:'A',seatCol:2,selected: false, disabled: false }, { seatRow:'A',seatCol:3, selected: false, disabled: false }, {  seatRow:'A',seatCol:4,selected: false, disabled: false }],
            [{ seatRow:'B',seatCol:1,selected: false, disabled: false }, { seatRow:'B',seatCol:2,selected: false, disabled: false }, { seatRow:'B',seatCol:3, selected: false, disabled: false }, {  seatRow:'B',seatCol:4,selected: false, disabled: false }],
            [{ seatRow:'C',seatCol:1,selected: false, disabled: false }, { seatRow:'C',seatCol:2,selected: false, disabled: false }, { seatRow:'C',seatCol:3, selected: false, disabled: false }, {  seatRow:'C',seatCol:4,selected: false, disabled: false }],
            [{ seatRow:'D',seatCol:1,selected: false, disabled: false }, { seatRow:'D',seatCol:2,selected: false, disabled: false }, { seatRow:'D',seatCol:3, selected: false, disabled: false }, {  seatRow:'D',seatCol:4,selected: false, disabled: false }]
          ],
          showConfirmation: true,
          selectedSeats: [],
          form: {
            date: '',
            time: '',
            hall: '',
          },
          showTimes: [],
          seatRow:'',
          seatCol:'',
          // seat:[],
        }
      },
      mounted(){
        this.id = this.$route.query.id,
        this.title = this.$route.query.title,
        this.description = this.$route.query.introduction
        // this.director = this.$route.query.director,
        // this.genre = this.$route.query.genre,
        // this.imageUrl = this.$route.query.imageUrl,
        // this.releaseDate = this.$route.query.releaseDate,
        // this.showStatus = this.$route.query.showStatus;
        // alert(this.id);
        const url = `${this.$root.$baseUrl}/sessions/${this.id}`
        this.axios.get(url).then(response =>{
          const data = response.data; 
          const code = data.code; 
            if(code === 20000) {
                  this.$store.state.code = 20000;
                } else {
                  this.$store.state.code = data.code;
                  alert(data.msg);
                }
          const dataList = data.data; 
          console.log(dataList);
          this.showTimes.push.apply(this.showTimes,dataList);
          this.$forceUpdate();
          // this.availableDates=[];
          availableDates.length = 0;
          this.showTimes.forEach(showTime => {
            const startDate = showTime.startTime.split(' ')[0]; // 提取年月日部分
            if (!availableDates.includes(startDate)) {
              availableDates.push(startDate);
            }
          });
        
        });
        // const urls = `${this.$root.$baseUrl}/seats/${this.form.hall}`
        // this.axios.get(urls).then(response =>{
        //   const data = response.data; 
        //   const code = data.code; 
        //     if(code === 20000) {
        //           this.$store.state.code = 20000;
        //         } else {
        //           this.$store.state.code = data.code;
        //           alert(data.msg);
        //         }
        //   this.seat = data.data;
        //   console.log(seat);
        // })
        
      },
      computed: {
        availableSeats() {
          return this.seatMap.reduce((acc, row) => {
            return acc.concat(row.filter(seat => !seat.selected && !seat.disabled))
          }, [])
        },
        filteredShowTimes() {
          if (!this.form.date) {
            return []; // 如果未选择日期，则返回空数组
          }
          const selectedDate = this.form.date.split(' ')[0]; 
          // const selectedDate = this.form.date;
          if (this.form.hall) {
            return this.showTimes.filter(showTime => {
              const startTime = showTime.startTime.split(' ')[0]; // 提取startTime的年月日部分
              return startTime === selectedDate && showTime.roomId === this.form.hall;
           });
          } else {
              return this.showTimes.filter(showTime => {
                const startTime = showTime.startTime.split(' ')[0]; // 提取startTime的年月日部分
                return startTime === selectedDate;
              });
            }   
          },

      },
      methods:{
        toggleSeat(seat) {
          if (!seat.disabled) {
            if (seat.selected) {
              seat.selected = false;
              this.selectedSeats.splice(this.selectedSeats.indexOf(seat), 1);
              this.updateSeatRowAndCol(); // 更新 seatRow 和 seatCol 的值
            } else {
              if (this.selectedSeats.length >= 1) {
                alert('一次最多只能选择1个座位');
              } else {
                seat.selected = true;
                this.selectedSeats.push(seat);
                this.updateSeatRowAndCol(); // 更新 seatRow 和 seatCol 的值
              }
            }
          }
        },
        updateSeatRowAndCol() {
        if (this.selectedSeats.length > 0) {
          const selectedSeat = this.selectedSeats[0]; // 假设只选择了一个座位
          this.seatRow = selectedSeat.seatRow;
          this.seatCol = selectedSeat.seatCol;
        } else {
          this.seatRow = null;
          this.seatCol = null;
        }
      },
        cancelSelection() {
          this.selectedSeats.forEach(seat => {
            seat.selected = false;
          });
          this.selectedSeats = [];
        },
        fetchSeatStatus() {
          if (!this.form.date || !this.form.hall || !this.form.time) {
            return; // 如果日期、放映厅或时间段未选择，则不发送请求
          }
          const selectedSessionId = this.showTimes.find(showTime => {
            const startTime = showTime.startTime.split(' ')[0];
            return (
              startTime === this.form.date &&
              showTime.roomId === this.form.hall &&
              showTime.startTime === this.form.time
            );
          }).id;
          this.isLoadingSeats = true; // 设置加载状态为true
          const url = `${this.$root.$baseUrl}/tickets/sessionId/${selectedSessionId}`
          this.axios.get(url).then(response => {
              const data = response.data
              console.log(data);
              const code = data.code;
              const seatStatus = data.data;
              if(code === 20000) {
                  this.$store.state.code = 20000;
                } else {
                  this.$store.state.code = data.code;
                  alert(data.msg);
                  this.isLoadingSeats = false;
                  return;
                }
              if(seatStatus === null)
                {
                  this.isLoadingSeats = false;
                }
              else {
                  this.updateSeatStatus(seatStatus);
                  this.isLoadingSeats = false;
                }
              
            })
        },
        updateSeatStatus(seatStatus) {
          seatStatus.forEach(seat => {
            const seatRow = seat.seatRow;
            const seatCol = seat.seatCol;

            // 遍历座位地图 seatMap
            this.seatMap.forEach(row => {
              row.forEach(seatItem => {
                // 判断当前座位的 seatRow 和 seatCol 是否与座位状态数据匹配
                if (seatItem.seatRow === seatRow && seatItem.seatCol === seatCol) {
                  // 将匹配到的座位状态设为禁用
                  seatItem.disabled = true;
                }
              });
            });
          });
        },
        confirmSelection() {
  
          if (!this.form.date || !this.form.time || !this.form.hall||this.selectedSeats.length === 0) {
            alert('请完善信息');
          return; 
          }
          else {
              const selectedSessionId = this.showTimes.find(showTime => {
              const startTime = showTime.startTime;
              const s2 = this.form.time;
              return (
                startTime ===s2&&showTime.roomId===this.form.hall
              );
            }).id;
            const ul = `${this.$root.$baseUrl}/seats/${this.form.hall}`;
            this.axios.get(ul).then(response =>{
              const data = response.data; 
              // console.log(data);
              const code = data.code; 
                if(code === 20000) {
                      this.$store.state.code = 20000;
                    } else {
                      this.$store.state.code = data.code;
                      alert(data.msg);
                    }
              const seatdata = data.data;
              const seatid =  seatdata.find(seatid =>{
              return(
                this.seatRow === seatid.seatRow && this.seatCol === seatid.seatCol
              );
            }).id
              const selectedSeatsData = {
                sessionId:selectedSessionId,
                // seatId:
                seatId:seatid
              };
              const url = `${this.$root.$baseUrl}/indents`;
            this.axios.post(url, selectedSeatsData)
              .then(response => {
                const data = response.data; 
                const code = data.code; 
                if(code === 20000) {
                      this.$store.state.code = 20000;
                    } else {
                      this.$store.state.code = data.code;
                      alert(data.msg);
                    }
                // 处理成功响应
                console.log('Ticket purchase successful:', response.data);
                alert('购票成功！');
                this.$message({
                  type:'success',
                  message:'即将返回电影详情页面',
                  duration:1000
                })
                setTimeout(() => {
                  this.ComeBack();
              }, 1000); // 设置延迟时间，单位为毫秒
                
                // 可以根据后端返回的数据进行相应的处理，其中包括生成的ticketId
              })
              .catch(error => {
                console.error('Failed to purchase ticket:', error);
              });
            });
            
            
          }
        },  
        getTimeSegment(startTime) {
          // 提取startTime的时分数据作为时间段
          // const time = startTime.split('T')[1].split(':')[0] + ':' + startTime.split('T')[1].split(':')[1];
             const time = startTime.split(' ')[1];
          // const time = startTime.split('T')[1].split(':')[0] + ':' + startTime.split('T')[1];
          return time;
        },
        ComeBack(){
          window.history.back();
        }
      },
    }
  </script>

<style scoped>
body{
    background-color: rgb(247,247,247);
  }
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 235px;
   }
  .header-content { 
    margin-left: 20px;
    margin-top: 15px;
   }
   .seat-map {
      display: flex;
      flex-direction: column;
      align-items: center;
      padding-top: 40px;
    }
    .seat-row {
      display: flex;
      justify-content: center;
      margin-bottom: 10px;
    }
    .seat {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 40px;
        height: 40px;
        margin-right: 10px;
        font-size: 16px;
        font-weight: bold;
        color: #fff;
        background-color: #ccc;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }
    .selected {
      background-color: #ffd04b;
    }
    .disabled {
      background-color: #F56C6C;
      cursor: not-allowed;
    }
    .selected-seat {
    display: inline-block;
    margin-right: 10px;
    padding: 5px 10px;
    font-size: 14px;
    font-weight: bold;
    color: #fff;
    background-color: #ffd04b;
    border-radius: 20px;
  }
    .confirmation {
      margin-top: 20px;
      padding: 20px;
      border: 1px solid black;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    .confirm-button, .cancel-button {
      margin: 10px;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      font-size: 18px;
      cursor: pointer;
    }
    .ulMessage {
      margin-bottom: 20px;
      list-style: none;
      padding: 0;
      }
      .liMessage {
        margin-bottom: 10px;
        font-size: 14px;
        font-weight: bold;
        text-align: center;
      }
      .seat-booking {
      justify-content: space-between;
      align-items: center;
      height: 100%;
    }
</style>










{
  "code": 20000,
  "msg": "操作成功",
  "data": [
      {
              
        "id": 79,
        "price": 35,
        "movieId": 37,
        "roomId": 1,
        "startTime": "2023-05-30T11:45:00.000+00:00"
      },
      {
        
        "id": 80,
        "price": 35,
        "movieId": 37,
        "roomId": 2,
        "startTime": "2023-05-26T11:45:00.000+00:00"
      },
  ]
}







