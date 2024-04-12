package main

import (
	"encoding/base64"
	"fmt"
)

var str2 = "[Id:1][info]doAction ok actId:1 When:true, Then:, ThenList:[HttpReq.Parse() Ctx.SetGlobal('GlbPlgJson', Sys.Load('GJson')) Ctx.SetGlobal('GlbHttpReq',  HttpReq.GetJson() ) Ctx.SetGlobal('GlbHttpRsp', HttpRsp ) Ctx.Log('请求参数', HttpReq ) Ctx.Log('请求参数Header', HttpReq.Header ) Ctx.Log('请求参数Body', GlbHttpReq )] ThenGroup:[]|[info]doAction ok actId:2 When:true, Then:, ThenList:[HttpReq.Header.Get('Seq') == '' ? Ctx.SetGlobal('GlbHttpReqSeq', '') : Ctx.SetGlobal('GlbHttpReqSeq', HttpReq.Header.Get('Seq')) HttpReq.Header.Get('trace_id') == '' ? false : Ctx.SetGlobal('GlbHttpReqSeq', HttpReq.Header.Get('trace_id')) GlbHttpReqSeq == '' ? Ctx.SetGlobal('GlbHttpReqSeq', HttpReq.Header.Get('staffname') + HttpReq.Header.Get('Safe-Trace-Id')) : true] ThenGroup:[]|[info]doAction ok actId:3 When:true, Then:, ThenList:[ GlbHttpReq.Get('type').Exists() ? Ctx.SetGlobal('GlbSafeType', GlbHttpReq.Get('type').String()) : Ctx.SetGlobal('GlbSafeType', '')   HttpReq.Header.Get('safe_type') != '' ? Ctx.SetGlobal('GlbSafeType', HttpReq.Header.Get('safe_type')) : false   GlbSafeType == '' ? Ctx.SetGlobal('GlbSafeType', HttpReq.Header.Get('Safe-Type')) : false  Ctx.Log('安全类型: ', GlbSafeType)] ThenGroup:[]|[info]doAction ok actId:4 When:true, Then:, ThenList:[Ctx.SetGlobal('GlbIsOldBuiness', GlbSafeType in ['meet', 'user', 'meet_user', 'meet_room', 'punish', 'tools', 'account', 'word', 'rule', 'trace', 'kv', 'asr'] ) GlbIsOldBuiness ? HttpRsp.Set('errorCode', 500, 'errorMsg', '服务异常') : HttpRsp.Set('code', 500, 'message', '服务异常', 'data', {})] ThenGroup:[]|[info]doAction ok actId:4 When:true, Then:, ThenList:[Ctx.SetGlobal('GlbStaffname', HttpReq.Header.Get('staffname')) HttpReq.SetAttrs('StaffName', HttpReq.Header.Get('staffname')) Ctx.Log('==================', GlbStaffname, HttpReq)] ThenGroup:[]|[info]doAction ok actId:1 When:true, Then:, ThenList:[Ctx.SetLocal('VarPath', Sys.Sprintf('%s%s', 'wemeet_safe_admin', HttpReq.Path)) Ctx.Log('请求七彩石路径', VarPath, GlbHttpReq) Ctx.Log('请求的safe_type', GlbSafeType) Ctx.DoSubRule(VarPath)] ThenGroup:[]|[info]doAction ok actId:1 When: true , Then:, ThenList:[HttpRsp.Write( HttpRsp.GetMap() )] ThenGroup:[]|[info]doAction ok actId:1 When: true , Then:, ThenList:[Ctx.Log('进入新策略', HttpRsp.GetMap()) Ctx.Cancel()] ThenGroup:[]|"

func main() {
	// base64编码
	base64Str := base64.StdEncoding.EncodeToString([]byte(str2))
	// base64解码
	decoded, err := base64.StdEncoding.DecodeString(base64Str)
	if err != nil {
		fmt.Println("解码失败：", err)
		return
	}

	// 输出解码后的字符串
	fmt.Println(string(decoded))
}
