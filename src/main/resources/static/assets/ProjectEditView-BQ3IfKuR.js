import{q as P,r as g,u as S,E as c,a as V,_ as U,c as b,e as o,C as K,b as y,w as r,F as D,i as u,D as j,o as s,f as v,g as f,G,h as L}from"./index-lKMbzYlX.js";import{B as M}from"./BreadCrumbNav-BtYp_qB0.js";import{p as h}from"./project-CxEimw6o.js";const p=V(!0),O="project",n=g({id:"",name:"",keyword:"",description:"",owner:""}),_=V(),E=g([]),T={components:{EditPen:P,BreadCrumbNav:M},setup(){return{loading:p,users:E,formData:n,formDataRef:_,formRules:g({name:[{required:!0,message:"请输入项目名称",trigger:"blur"},{max:50,message:"项目名称不能超过50个字",trigger:"blur"}],description:[{max:200,message:"项目描述不能超过200个字",trigger:"blur"}],keyword:[{required:!0,message:"请输入项目关键字",trigger:"blur"},{max:20,message:"项目关键字不能超过20个字",trigger:"blur"}],owner:[{required:!0,message:"请选择项目负责人",trigger:"blur"}]})}},mounted(){p.value=!0,n.id=this.$route.query.id?this.$route.query.id.toString():"",S.all().then(a=>{E.length=0,Object.assign(E,a)}),h.get(n.id).then(a=>{a&&(n.name=a.name,n.keyword=a.keyword,n.description=a.description,n.owner=a.owner.id),p.value=!1})},methods:{handleSubmit(){try{_.value.validate().then(()=>{h.modify(n).then(a=>{a.success?(c.success("修改成功"),_.value.resetFields(),this.$router.push("/"+O+"/list")):c.error("修改失败")})})}catch{c.error("请检查输入内容")}},handleReturn(){this.$router.go(-1)}}},z={class:"card-header"};function H(a,e,J,t,Q,i){const k=u("BreadCrumbNav"),x=u("EditPen"),F=u("el-icon"),m=u("el-input"),d=u("el-form-item"),B=u("el-option"),C=u("el-select"),N=u("el-form"),w=u("el-button"),q=u("el-row"),R=u("el-card"),A=j("loading");return s(),b(D,null,[o(k,{"page-paths":["项目管理","项目列表","项目修改"]}),K((s(),y(R,{class:"info-card",shadow:"never"},{header:r(()=>[v("div",z,[o(F,null,{default:r(()=>[o(x)]),_:1}),e[4]||(e[4]=f("  项目修改 "))])]),footer:r(()=>[o(q,{class:"row-bg",justify:"end"},{default:r(()=>[e[7]||(e[7]=v("div",{class:"flex-grow"},null,-1)),o(w,{type:"info",onClick:i.handleReturn,round:""},{default:r(()=>e[5]||(e[5]=[f("返回项目列表")])),_:1},8,["onClick"]),o(w,{type:"primary",onClick:i.handleSubmit,round:""},{default:r(()=>e[6]||(e[6]=[f("提交")])),_:1},8,["onClick"])]),_:1})]),default:r(()=>[o(N,{ref:"formDataRef",model:t.formData,rules:t.formRules,"label-width":"30%",style:{width:"60%"},onKeyup:L(i.handleSubmit,["enter"])},{default:r(()=>[o(d,{label:"项目名称",prop:"name"},{default:r(()=>[o(m,{modelValue:t.formData.name,"onUpdate:modelValue":e[0]||(e[0]=l=>t.formData.name=l)},null,8,["modelValue"])]),_:1}),o(d,{label:"项目关键字",prop:"keyword"},{default:r(()=>[o(m,{modelValue:t.formData.keyword,"onUpdate:modelValue":e[1]||(e[1]=l=>t.formData.keyword=l)},null,8,["modelValue"])]),_:1}),o(d,{label:"项目描述信息",prop:"description"},{default:r(()=>[o(m,{modelValue:t.formData.description,"onUpdate:modelValue":e[2]||(e[2]=l=>t.formData.description=l),type:"textarea",maxlength:"200","show-word-limit":""},null,8,["modelValue"])]),_:1}),o(d,{label:"项目负责人",prop:"owner"},{default:r(()=>[o(C,{modelValue:t.formData.owner,"onUpdate:modelValue":e[3]||(e[3]=l=>t.formData.owner=l),placeholder:"请选择...","no-data-text":"暂无用户"},{default:r(()=>[(s(!0),b(D,null,G(t.users,l=>(s(),y(B,{key:l.id,label:l.realName,value:l.id},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1},8,["model","rules","onKeyup"])]),_:1})),[[A,t.loading]])],64)}const Z=U(T,[["render",H]]);export{Z as default};