<template>
<div id="body">
  <div class='card'>
    <div class="imgBox">
      <img src="./book.png">
    </div>
    <div class='details'>
      <!-- <h2 >《这样跟孩子定规矩孩子最不会抵触》</h2> -->
      <p style="font-size:15px;color:#FF5100;">
        乔治.M.卡帕卡（George M.Kapalka ,PH.D.）：国际著名育儿专家，执业临床心理学家，美国心理学会资深会员，美国新泽西州布里克市“行为矫正中心”主任，蒙茅斯大学心理咨询专业副教授。
推荐理由：
    只要掌握跟孩子定规矩的法则，孩子就完全照着你的去做！懂得听从他人的正确指导，是塑造孩子完美性格的重要基础，也是使孩子买上成功之路的关键!


     
      </p>
    </div>
  </div>
</div>


</template>

   <style scoped>


    #body {
        width: 100%;
      height: 100%;
      margin: 0;
      padding: 0;
     background-image: url(./sun.jpg);
    }

    img {
      width: 100%;
      height: 100%;
    }

    .card {
      position: absolute;
      top: 50%;
      left: 50%;
      width: 300px;
      height: 400px;
      background: #fff;
      transform-style: preserve-3d;
      transform: translate(-50%, -50%) perspective(2000px);
      box-shadow: inset 300px 0 50px rgba(0, 0, 0, 0.5), 0 20px 100px rgba(0, 0, 0, 0.5);
      transition: 1s;
    }

    .card:hover {
      transform: translate(-50%, -50%) perspective(2000px) rotate(-10deg);
      box-shadow: inset 20px 0 50px rgba(0, 0, 0, 0.5), 0 10px 100px rgba(0, 0, 0, 0.5);
    }

    .card::before {
      content: '';
      position: absolute;
      top: -5px;
      left: 0;
      width: 100%;
      height: 5px;
      z-index: 10;
      background: #475b02;
      transform: skewX(-45deg);
    }

    .card::after {
      content: '';
      position: absolute;
      top: 0;
      right: -5px;
      width: 5px;
      height: 100%;
      background-color: #7ea301;
    }

    .card .imgBox {
      user-select: none;
      width: 100%;
      height: 100%;
      position: relative;
      transform-origin: left;
      transition: 1s cubic-bezier(.15, 1.7, .84, .58);

    }

    .card:hover .imgBox {
      transform: rotateY(-155deg);
    }

    .card .details {
      position: absolute;
      top: 0;
      left: 0;
      box-sizing: border-box;
      padding: 20px;
      z-index: -1;
    }
  </style>