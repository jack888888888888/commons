import request from '@/utils/request'

// 查询新闻列表
export function listJournalism(query) {
  return request({
    url: '/business/journalism/list',
    method: 'get',
    params: query
  })
}

// 查询新闻详细
export function getJournalism(id) {
  return request({
    url: '/business/journalism/' + id,
    method: 'get'
  })
}

// 新增新闻
export function addJournalism(data) {
  return request({
    url: '/business/journalism',
    method: 'post',
    data: data
  })
}

// 修改新闻
export function updateJournalism(data) {
  return request({
    url: '/business/journalism',
    method: 'put',
    data: data
  })
}

// 删除新闻
export function delJournalism(id) {
  return request({
    url: '/business/journalism/' + id,
    method: 'delete'
  })
}
