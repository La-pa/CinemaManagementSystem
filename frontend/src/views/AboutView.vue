<template>
  <div class="about">
    <h1>This is an about page</h1>
        <img src="https://img2.doubanio.com/view/photo/m/public/p480747492.webp" alt="">
    <UserTable></UserTable>
    </div>
</template>

<script>
import UserTable from '@/components/UserTable.vue'

export default {
  name: 'Users',
  components: {
    UserTable
  }
}
</script>



