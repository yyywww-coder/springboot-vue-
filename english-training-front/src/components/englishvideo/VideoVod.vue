<template>
    <el-dialog :visible.sync="visible" title="视频播放" :close-on-click-modal="false" :close-on-press-escape="false"
               :before-close="closeVal">
        <div :id="playerId" class="prism-player"/>
    </el-dialog>
</template>

<script>
export default {
  props: {
    aliplayerSdkPath: {
      // Aliplayer 代码的路径
      type: String,
      default: 'https://g.alicdn.com/de/prismplayer/2.9.3/aliplayer-min.js'
    }
  },
  data () {
    return {
      visible: false,
      playerId: 'aliplayer_' + Math.random().toString(36).substr(2),
      scriptTagStatus: 0,
      isReload: false,
      instance: null,
      vid: '',
      playauth: '',
      cover: ''
    }
  },
  mounted () {
      if (window.Aliplayer !== undefined) {
      // 如果全局对象存在，说明编辑器代码已经初始化完成，直接加载编辑器
      this.scriptTagStatus = 2
      this.initAliplayer()
    } else {
      // 如果全局对象不存在，说明编辑器代码还没有加载完成，需要加载编辑器代码
      this.insertScriptTag()
    }
  },
  methods: {
    async init(vid){
      this.visible = true
      await this.$axios.get('/oss/file/getVideoPlayAuth', { params: { videoId: vid } }).then(({ data: res }) => {
        console.log(res)
        if (res.data.Code !== '0') {
          return this.$message.error(res.msg)
        }
        console.log('fetch---', res)
        this.cover = res.data.CoverUrl
        this.playauth = res.data.PlayAuth
        this.vid = res.data.VideoId
      })
      // eslint-disable-next-line
                if (window.Aliplayer !== undefined) {
        // 如果全局对象存在，说明编辑器代码已经初始化完成，直接加载编辑器
        this.scriptTagStatus = 2
        this.initAliplayer()
      } else {
        // 如果全局对象不存在，说明编辑器代码还没有加载完成，需要加载编辑器代码
        this.insertScriptTag()
      }
    },
    closeVal () {
      console.log('-----2-----------')
      this.$emit('my-event', 0)
    },
    insertScriptTag () {
      const _this = this
      let playerScriptTag = document.getElementById('playerScriptTag')
      // 如果这个tag不存在，则生成相关代码tag以加载代码
      if (playerScriptTag === null) {
        playerScriptTag = document.createElement('script')
        playerScriptTag.type = 'text/javascript'
        playerScriptTag.src = _this.aliplayerSdkPath
        playerScriptTag.id = 'playerScriptTag'
        const s = document.getElementsByTagName('head')[0]
        s.appendChild(playerScriptTag)
      }
      if (playerScriptTag.loaded) {
        _this.scriptTagStatus++
      } else {
        playerScriptTag.addEventListener('load', () => {
          _this.scriptTagStatus++
          playerScriptTag.loaded = true
          _this.initAliplayer()
        })
      }
      _this.initAliplayer()
    },
    initAliplayer () {
      const _this = this
      // scriptTagStatus 为 2 的时候，说明两个必需引入的 js 文件都已经被引入，且加载完成
      if (
        _this.scriptTagStatus === 2 &&
                    (_this.instance === null || _this.reloadPlayer)
      ) {
        _this.instance && _this.instance.dispose()

        document.querySelector('#' + _this.playerId).innerHTML = ''

        // Vue 异步执行 DOM 更新，这样一来代码执行到这里的时候可能 template 里面的 script 标签还没真正创建
        // 所以，我们只能在 nextTick 里面初始化 Aliplayer
        _this.$nextTick(() => {
          // eslint-disable-next-line
                        const player = new Aliplayer({
            'id': _this.playerId,
            'width': '100%',
            'height': '500px',
            'autoplay': true,
            'isLive': false,
            'rePlay': false,
            'playsinline': true,
            'preload': true,
            'controlBarVisibility': 'hover',
            'useH5Prism': true,
            'vid': _this.vid,
            'playauth': _this.playauth,
            'cover': _this.cover
          }, function (player) {
            // console.log('123')
          })
        })
      }
    }
  }
}
</script>
<style>
    @import url(https://g.alicdn.com/de/prismplayer/2.9.3/skins/default/aliplayer-min.css);
</style>
