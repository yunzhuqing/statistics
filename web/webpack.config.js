const VueLoaderPlugin = require('vue-loader/lib/plugin')

module.exports = {
    entry: './index.js',
    output: {
        path: __dirname,
        filename: "bundle.js"
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    module:{
        rules:[
            {test:/\.vue$/,use:'vue-loader'}
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ]
}