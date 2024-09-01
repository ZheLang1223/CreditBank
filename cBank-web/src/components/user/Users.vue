<template>
  <div>
    <input v-model="nameFilter" placeholder="Filter by name" @input="fetchData" />
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.name }}</td>
        <td>{{ user.email }}</td>
      </tr>
      </tbody>
    </table>
    <button @click="prevPage" :disabled="current === 1">Previous</button>
    <button @click="nextPage" :disabled="current === totalPages">Next</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      users: [],
      current: 1,
      size: 10,
      totalPages: 1,
      nameFilter: '',
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    async fetchData() {
      try {
        const response = await axios.get('/users/page', {
          params: {
            current: this.current,
            size: this.size,
            nameFilter: this.nameFilter,
          },
        });
        this.users = response.data.records;
        this.totalPages = response.data.pages;
      } catch (error) {
        console.error('Failed to fetch data', error);
      }
    },
    nextPage() {
      if (this.current < this.totalPages) {
        this.current++;
        this.fetchData();
      }
    },
    prevPage() {
      if (this.current > 1) {
        this.current--;
        this.fetchData();
      }
    },
  },
};
</script>
