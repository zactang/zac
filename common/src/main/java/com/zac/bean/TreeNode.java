package com.zac.bean;

import java.util.List;

/**
 * TreeNode
 * @author ZacTang
 *
 */
public class TreeNode implements java.io.Serializable {

	/**
	 * Auto SVUID
	 */
	private static final long serialVersionUID = 5789945080235704948L;

	private Integer id;//PK
	private String code;//code
	private String url;//URL
	private String title;//show name
	private Object data;//data
	private Integer pid;//parent Id
	private Integer lv;
	private Boolean isLeaf=false; //is leaf node
	private List<TreeNode> child;//child
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return the child
	 */
	public List<TreeNode> getChild() {
		return child;
	}
	/**
	 * @param child the child to set
	 */
	public void setChild(List<TreeNode> child) {
		this.child = child;
	}
	/**
	 * @return the lv
	 */
	public Integer getLv() {
		return lv;
	}
	/**
	 * @param lv the lv to set
	 */
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	/**
	 * @return the isLeaf
	 */
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	/**
	 * @param isLeaf the isLeaf to set
	 */
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
	
	
}
