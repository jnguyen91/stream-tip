<template>
  <div class="home">
    <Nav @logout="logout" :logged-in="loggedIn" v-if="loggedIn"></Nav>
    <Login v-if="!loggedIn" @login="login"></Login>
    <Main v-if="loggedIn"></Main>
  </div>
</template>

<script>
import Nav from '@/components/Nav.vue';
import Login from '@/components/Login.vue';
import Main from '@/components/Main.vue';

export default {
  name: 'home',

  components: {
    Nav,
    Login,
    Main,
  },

  data() {
    return {
      loggedIn: sessionStorage.getItem('authenticated'),
    };
  },

  methods: {
    login() {
      this.loggedIn = true;
    },

    logout() {
      this.loggedIn = false;
    },
  },
};
</script>
