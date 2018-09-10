<template>
  <div class="login container">
    <div class="row">
      <div class="three columns">&nbsp;</div>
      <div class="six columns">
        <div>
          <label for="username">Your username</label>
          <input class="u-full-width" type="text" placeholder="admin" v-model="username">
        </div>
        <div>
          <label for="password">Your password</label>
          <input class="u-full-width" type="password" placeholder="Enter your password" v-model="password">
        </div>
      </div>
      <div class="three columns">&nbsp;</div>
    </div>
    <input class="button-primary" type="submit" value="Login" @click="login">

    <div class="error-box" v-if="showError">
      <i class="fas fa-exclamation-triangle fa-2x"></i>
      <p>Warning! Incorrect username or password</p>
      <a href="javascript:;" class="button button-primary" @click="showError = false">Close</a>
    </div>
  </div>
</template>

<style lang="scss" scoped>
  .error-box {
    width: 250px;
    margin: 0 auto;
    display: block;
    position: absolute;
    padding: 20px;
    font-weight: 600;
    left: 0;
    right: 0;
    top: 50px;
    background: linear-gradient(0deg, #fff, #f7f7f7) !important;
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#f7f7f7, endColorstr=$white) !important;
    -webkit-filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#f7f7f7, endColorstr=$white) !important;
        box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
      -webkit-box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
      -moz-box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
      -o-box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
  }
</style>

<script>
export default {
  name: 'Login',

  data() {
    return {
      username: '',
      password: '',
      showError: false,
    };
  },

  methods: {
    login() {
      if (this.username === 'admin' && this.password === 'password') {
        sessionStorage.setItem('authenticated', 'true');
        this.$emit('login');
      } else {
        this.password = '';
        this.showError = true;
      }
    },
  },

};
</script>
