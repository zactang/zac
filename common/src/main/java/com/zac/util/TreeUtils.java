package com.zac.util;

import java.util.ArrayList;
import java.util.List;

import com.zac.bean.TreeNode;


/**
 * Tree Tools
 * @author ZacTang
 *
 */
public class TreeUtils {

	
	/**
	 * 把list变成树状结构
	 * @param list List<TreeNode>
	 * @return List<TreeNode> about child List
	 */
	public static List<TreeNode> dolist(List<TreeNode> list,Integer rootPId){
		
		List<TreeNode> list_new=new ArrayList<TreeNode>();
		for (TreeNode areaDto : list) {
			if(areaDto.getPid()==rootPId){//ROOT
				areaDto.setLv(1);
				areaDto.setChild(finchild(areaDto,list));
				list_new.add(areaDto);
			}
		}
		return list_new;
	}
	private static List<TreeNode> finchild(TreeNode dto,List<TreeNode> list){
		List<TreeNode> list_new=new ArrayList<TreeNode>();
		for (TreeNode areaDto : list) {
			if(areaDto.getPid()== dto.getId()){
				List<TreeNode> tmp=finchild(areaDto,list);
				if(tmp==null||tmp.size()==0){
					areaDto.setLv(dto.getLv()+1);
					areaDto.setIsLeaf(true);
					list_new.add(areaDto);
					continue;
				}
				areaDto.setChild(tmp);
				list_new.add(areaDto);
			}
		}
		return list_new;
	}
}
