<template>
	<div class="main margin-top--60px">
		<div v-if="currentStep == 1">
			<h1>Search for a gif</h1>
			<input type="text" v-model="searchGif" >
			<a href="javascript:;" @click="search()" class="search-btn"><i class="fas fa-search"></i></a>
			<hr>
			<h1>Or select a gif</h1>
			<div class="gif" :class="{'selected': gif === selectedGif}" v-for="gif in gifs">
				<video :src="gif.mobileUrl" width="120px" height="120px" @click="selectGif(gif)" autoplay :muted="true" loop>
				</video>
			</div>
			<div class="margin-top--60px">
				<a href="javascript:;" class="button button-primary" @click="nextStep()">Continue</a>
			</div>
		</div>

		<div v-if="currentStep == 2">
			<div class="container">
				<h1>Enter a tip amount (min $1)</h1>
				<input type="text" placeholder="e.g,. 5" v-model="tipAmount">
			</div>
			<div class="margin-top--20px">
				<a href="javascript:;" class="button button-primary" @click="previousStep()">Back</a>
				<a href="javascript:;" class="button button-primary" style="margin-left: 20px;" @click="submit()">Submit</a>
			</div>
		</div>

		<div v-if="currentStep == 3">
			<div class="container">
				<div class="card">
					<video :src="selectedGif.mobileUrl" width="120px" height="120px" autoplay :muted="true" loop>
					</video>
					<p>${{ tipAmount }}</p>
					<div class="margin-top--10px">
						<a href="javascript:;" class="button button-primary" @click="firstStep()">Do it again!</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<style scoped lang="scss">
	.margin-top--60px {
		margin-top: 60px;
	}

	.margin-top--20px {
		margin-top: 20px;
	}

	.margin-top--10px {
		margin-top: 10px;
	}

	.gif {
		display: inline-block;
		height: 120px !important;
		width: 120px !important;
		margin-right: 10px;
		border-radius: 4px;
		cursor: pointer;
	}

	.selected {
		outline: 4px solid #25D189;
		border-radius: 4px;
	}

	.card {
		border: 2px solid #ddd;
		width: 200px;
		margin: 0 auto;
		padding: 20px;
		border-radius: 4px;
		font-weight: 600;
		video {
			display: block;
			margin: 0 auto;
		}
	}

	.search-btn {
		border: 1px solid #ddd;
		padding: 8px;
		color: #333;
		border-radius: 4px;
		margin-left: 10px;
		height: 40px;
	}
</style>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      gifs: [],
      currentStep: 1,
      selectedGif: null,
      tipAmount: null,
      searchGif: null,
    };
  },

  mounted() {
    this.getTrendingGifs();
  },

  methods: {
    selectGif(gif) {
      this.selectedGif = gif;
    },

    nextStep() {
      this.currentStep = this.currentStep + 1;
    },

    previousStep() {
      this.currentStep = this.currentStep - 1;
    },

    submit() {
      this.currentStep = 3;
    },

    firstStep() {
      this.currentStep = 1;
    },

    getTrendingGifs() {
      axios.get('https://api.gfycat.com/v1/gfycats/trending')
        .then((res) => {
          this.gifs = res.data.gfycats;
        });
    },

    search() {
      if (this.searchGif !== '') {
        axios.get(`https://api.gfycat.com/v1/gfycats/search?search_text=${this.searchGif}`)
          .then((res) => {
            this.gifs = res.data.gfycats;
          });
      } else {
        this.getTrendingGifs();
      }
    },
  },
};
</script>
