const path=require('path')
const VueLoaderPlugin = require('vue-loader/lib/plugin');
var ParallelUglifyPlugin = require('webpack-parallel-uglify-plugin');
const os = require('os');
const HappyPack = require('happypack');

const happyThreadPool = HappyPack.ThreadPool({ size: 8 });

new ParallelUglifyPlugin({
    cacheDir: '.cache/',
    uglifyJS:{
        output: {
            comments: false
        },
        compress: {
            warnings: false
        }
    }
})

module.exports = {
    entry: './index.js',
    output: {
        path: __dirname,
        filename: "bundle.js"
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js',
            'iview$': 'iview/dist/iview.js'
        }
    },
    module:{
        rules:[
            {
                test:/\.js$/,
                use:[
                    {
                        loader: 'happypack/loader?id=happyBabel'
                    }
                ],
                exclude: path.resolve(__dirname, 'node_modules'),
            },
            {
                test:/\.vue$/,
                use:[
                    {
                        loader: 'vue-loader',
                        options: {
                        }
                    },
                    {
                        loader: 'iview-loader',
                        options: {
                            prefix: false
                        }
                    }
                ]
            },
            {
                test: /\.css$/,
                use:[
                    {
                        loader: 'style-loader'
                    },
                    {
                        loader: 'css-loader'
                    }
                ]
            },
            {
                test: /\.(svg|ttf|eot|woff)\??.*$/,
                use:[
                    {
                        loader: 'url-loader',
                        options:{
                            limit: 10000
                        }
                    }
                ]
            },
            {
                test: /\.(ttf|eot|woff)\??.*$/,
                use:[
                    {
                        loader: 'file-loader',
                        options:{
                        }
                    }
                ]
            },
            {
                test: /\.js$/,
                loader: 'happypack/loader?id=happyBabel',
                exclude: /node_modules/
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
        new HappyPack({
            id: 'happyBabel',
            loaders: [{
                loader: 'babel-loader',
                options: { babelrc: true, cacheDirectory: true }
            }],
            //共享进程池
            threadPool: happyThreadPool,
            //允许 HappyPack 输出日志
            verbose: true
        })
    ]
}