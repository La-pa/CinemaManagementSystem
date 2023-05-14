<template>
  <div class="about">
    <h1>This is an about page</h1>
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



