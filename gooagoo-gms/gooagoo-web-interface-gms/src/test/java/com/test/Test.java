package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.view.gms.member.FMemberFeature;

public class Test {
	public static void main(String[] args) {
       List<FMemberFeature> fMemberFeatures = new ArrayList<FMemberFeature>();
       FMemberFeature feature = new FMemberFeature();
       feature.setId("123456789");
       fMemberFeatures.add(feature);
       List<FMemberFeature> memberFeatures2 = new ArrayList<FMemberFeature>();
       org.springframework.beans.BeanUtils.copyProperties(feature, memberFeatures2);
       System.out.println(memberFeatures2.get(0).getId());
	}
}
