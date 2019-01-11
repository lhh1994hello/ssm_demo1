package com.atguigu.crud.test;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

//作者:lhh 创建时间:2018年11月26日 上午11:44:41 
public class JsonTest1 {
	@Test
	public void fun1(){
		
		StringBuffer  sql=new StringBuffer();

		sql.append(" select zza.applyNumber,  zza.applyType, zza.complaintType,zza.createUserId,  zza.createUserName,zza.emergency, zza.custName, zza.custSex, zza.custContact,   zza.custId, zza.orgName,zza.prodType,zza.prodName, zza.cesAcno,zza.telNo,  zza.procStatus, zza.isOverTimeCase,zza.createTime, zza.apRemark,   zza.NOTEBNAME,zza.optUserName, zza.optNote,  zza.auRemark, zza.custCompType,zza.stepRole,zza.stepRoleName ");
		
		sql.append(" from (select ap1.apply_number applyNumber,  ap1.TYPE applyType,ap1.COMPLAINT_TYPE complaintType, ap1.CREATE_USER_ID createUserId, ap1.CREATE_USER_NAME createUserName,ap1.EMERGENCY emergency,ap1.CUST_NAME custName,ap1.CUST_SEX custSex,ap1.CUST_CONTACT custContact,ap1.CUST_ID custId,KFRE.ORG_NAME orgName,ap1.PROD_TYPE prodType,ap1.PROD_NAME prodName,ap1.CESACNO cesAcno,T.TEL_NO telNo, ap1.PROC_STATUS procStatus, ap1.IS_OVERTIME_CASE isOverTimeCase,to_char(ap1.CREATE_TIME, 'yyyy-mm-dd HH24:mi:ss') createTime,");
		sql.append(" ap1.REMARK apRemark,au1.step_role_name NOTEBNAME, au1.OPT_USER_NAME optUserName,au1.OPT_NOTE optNote, au1.remark auRemark,ap1.CUST_COMP_TYPE custCompType,au1.step_role stepRole,au1.step_role_name stepRoleName");
		sql.append(" from apply_record ap1  left join KF_REGION_ORG KFRE ON ap1.AREA_CENTER_CODE = KFRE.ORG_CODE  left join TEL_RECORD T  ON ap1.TEL_ID = T.ID  LEFT JOIN AUDIT_RECORD au1  ON au1.APPLY_NUMBER = ap1.APPLY_NUMBER  and au1.audit_id in  ");
		
		
		sql.append(" ( select audit_id from AUDIT_RECORD t1  where t1.apply_number = ap1.apply_number   and t1.create_time = (select max(create_time)  from AUDIT_RECORD t2 where ap1.apply_number = t2.apply_number))  ) zza,  ( ");
		sql.append(" select t.apply_number applyNumber ");
		sql.append("  from custap.apply_record t   left join custap.KF_REGION_ORG a  on t.AREA_CENTER_CODE = a.org_code   join custap.audit_record b  on t.apply_number = b.apply_number  and b.audit_id in  (select audit_id  from custap.audit_record tempb0   where tempb0.apply_number = t.apply_number  and tempb0.create_time = ");
		sql.append("  (select max(create_time)  from custap.audit_record tempb1 where tempb1.apply_number = t.apply_number ");
		sql.append("");
		sql.append("");
		
		//sql.append("  select ap2.apply_number applyNumber from apply_record ap2  left join KF_REGION_ORG KFRE2   on ap2.AREA_CENTER_CODE = KFRE2.org_code   left join AUDIT_RECORD au2 on ap2.apply_number = au2.apply_number  and au2.audit_id in ( ");
		//sql.append(" select audit_id from AUDIT_RECORD t4 where ap2.apply_number = t4.apply_number  and t4.create_time =  (select max(create_time)  from AUDIT_RECORD t5  where ap2.apply_number = t5.apply_number  ");
		
		//所经过的岗位
//		if (stepRoleName != null && !"".equals(stepRoleName) && noStepRoleName != null && !"".equals(noStepRoleName)) {
//			return null;
//		}
//		if(StringUtils.isNotBlank(stepRoleName)){
//			sql.append("  and tempb1.step_role_name = ?");
//			params.add(stepRoleName);
//		}
//		//未经岗位
//		if(StringUtils.isNotBlank(noStepRoleName)){
//			sql.append("   and tempb1.step_role_name != ? ");
//			params.add(noStepRoleName);
//		}
		
		sql.append("  ))) zzb ");
		sql.append("  where zza.applyNumber = zzb.applyNumber ");
		sql.append(" order by zza.applyNumber desc");//去掉分号
		System.out.println(sql.toString());
	}
}
