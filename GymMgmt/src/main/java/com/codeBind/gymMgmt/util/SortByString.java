package com.codeBind.gymMgmt.util;

import java.util.Comparator;

import com.codeBind.gymMgmt.model.Vo.AccessGroupVo;

public class SortByString implements Comparator<AccessGroupVo> {

	@Override
	public int compare(AccessGroupVo accessGroupVo1, AccessGroupVo accessGroupVo2) {
		Integer sec1 = ((AccessGroupVo) accessGroupVo1).getSectionSrNo();
		Integer sec2 = ((AccessGroupVo) accessGroupVo2).getSectionSrNo();
		int sComp = sec1.compareTo(sec2);

		if (sComp != 0) {
			return sComp;
		} else {
			Integer mod1 = ((AccessGroupVo) accessGroupVo1).getMstModuleSrNo();
			Integer mod2 = ((AccessGroupVo) accessGroupVo2).getMstModuleSrNo();
			return mod1.compareTo(mod2);
		}
	}

}
