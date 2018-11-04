<template>
    <div class="layout">
        <Layout>
            <Layout>
                <Sider hide-trigger :style="{background: '#fff'}" style="height: 760px;">
                    <Menu active-name="click" theme="light" width="auto" :open-names="['1']" @on-select="selectMenu">
                        <Submenu name="1">
                            <template slot="title">
                                <Icon type="ios-navigate"></Icon>
                                常用统计
                            </template>
                            <MenuItem name="1-1">事件统计</MenuItem>
                        </Submenu>
                    </Menu>
                  <Menu active-name="user" theme="light" width="auto"  @on-select="selectMenu">
                    <Submenu name="2">
                      <template slot="title">
                        <Icon type="ios-people" />
                        用户统计
                      </template>
                      <MenuItem name="2-1">用户增长趋势</MenuItem>
                    </Submenu>
                  </Menu>
                  <Menu active-name="trade" theme="light" width="auto" @on-select="selectMenu">
                    <Submenu name="1">
                      <template slot="title">
                        <Icon type="logo-usd" />
                        订单统计
                      </template>
                      <MenuItem name="3-1">今日订单趋势</MenuItem>
                    </Submenu>
                  </Menu>
                </Sider>
                <Layout :style="{padding: '0 24px 24px'}">
                    <Click v-if="item == '1-1'"></Click>
                </Layout>
                <Layout :style="{padding: '0 24px 24px'}">
                  <User v-if="item == '2-1'"></User>
                </Layout>
                <Layout :style="{padding: '0 24px 24px'}">
                  <label v-if="item == '3-1'">交易</label>
                </Layout>
            </Layout>
        </Layout>
    </div>
</template>

<script>
    import Click from './click.vue'
    import User from './user.vue'
    export default {
        name: "index",
        data () {
            return {
                theme2: 'light',
                item: '1-1'
            }
        },
        methods: {
            selectMenu: function (name) {
                this.item = name;
            }
        },
        components: {
          'Click': Click,
          'User': User
        }
    }
</script>

<style scoped>
    .layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
    }
    .layout-logo{
        width: 100px;
        height: 30px;
        background: #5b6270;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 15px;
        left: 20px;
    }
    .layout-nav{
        width: 420px;
        margin: 0 auto;
        margin-right: 20px;
    }
</style>
