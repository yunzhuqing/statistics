import Vue from 'vue';
import ViserVue from 'viser-vue';
import iView from 'iview';
import 'iview/dist/styles/iview.css';

import Index from './pages/index.vue';



Vue.use(ViserVue);
Vue.use(iView);


var app = new Vue({
    el: '#app',
    data: {
        message: 'hello world'
    },
    components: {
        'Index': Index
    }
});