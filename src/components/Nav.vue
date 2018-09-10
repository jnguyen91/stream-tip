<template>
	<div class="nav margin-bot--20px">
		<div class="container">
			<div class="right">
				<a class="button button-primary" href="javascript:;" @click="logout()">Logout</a>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
</template>

<style scoped>
	.nav {
		background: #fff;
		width: 100%;
		min-height: 48px;
		padding-top: 10px;
		background: linear-gradient(0deg, #fff, #f7f7f7) !important;
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#f7f7f7, endColorstr=$white) !important;
		-webkit-filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#f7f7f7, endColorstr=$white) !important;
		    box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
	    -webkit-box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
	    -moz-box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
	    -o-box-shadow: 0 1px 10px 0 rgba(50,50,50,0.2);
	}

	.right {
		float: right;
	}

	.margin-bot--20px {
		margin-bottom: 20px;
	}

</style>

<script>

export default {
  props: ['loggedIn'],
  methods: {
    logout() {
      sessionStorage.clear();
      this.$emit('logout');
    },
  },
};
</script>
