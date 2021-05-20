<template>
  <div id="newsinfo" >
    <div class="newsHead" >
      <img src="@/assets/images/news/newshead.jpg" alt="" height="500px" width="100%" />
    </div>
    <div class="newstitle">
	    <h2>{{newsData.title}}</h2>

      
    </div>
    <p>{{newsData.cotent}}</p>
	  </div>
</template>

<script>
export default {
  data() {
    return {
      id: this.$route.params.id, //这样我们的id就拿到了然后在接口处拼接
      newsData: {
        title: "",
        cotent: "",
      },
    };
  },

  created() {
    let id = this.id;
    this.$axios
      .get("/front/news/item", {
        params: {
          id: id,
        },
      })
      .then((ref) => {
        console.log(ref);
        this.totalCount = ref.data.data.total;
        this.newsData = ref.data.data;
        this.pageIndex = ref.data.data.pageNum;
      });
  },
};
</script>

<style scoped>
.newstitle{
  margin-left: 45%;
}
.newstitle h2{
  margin-top: 60px;
  margin-bottom: 50px;
  font-size: 35px;
}
#newsinfo p{
  margin-left:20%;
   margin-right:20%;
  font-size: 20px;
    margin-bottom: 200px;
}
</style>