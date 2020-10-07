import request from '@/utils/request'
import Qs from "qs"

export function login(data) {
  return request({
    url: '/userApi/user',
    method: 'post',
    data: Qs.stringify(data),
    params:{
      methodName:"login"
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/tokenApi/token',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/userApi/user',
    method: 'post',
    params:{
      methodName:'logout'
    }
  })
}
