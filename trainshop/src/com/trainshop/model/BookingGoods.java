package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BookingGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "booking_goods", catalog = "trainshop")
public class BookingGoods implements java.io.Serializable {

	// Fields

	private Long recId;
	private Long userId;
	private String email;
	private String linkMan;
	private String tel;
	private Integer goodsId;
	private String goodsDesc;
	private Long goodsNumber;
	private Long bookingTime;
	private Integer isDispose;
	private String disposeUser;
	private Long disposeTime;
	private String disposeNote;

	// Constructors

	/** default constructor */
	public BookingGoods() {
	}

	/** full constructor */
	public BookingGoods(Long userId, String email, String linkMan, String tel,
			Integer goodsId, String goodsDesc, Long goodsNumber,
			Long bookingTime, Integer isDispose, String disposeUser,
			Long disposeTime, String disposeNote) {
		this.userId = userId;
		this.email = email;
		this.linkMan = linkMan;
		this.tel = tel;
		this.goodsId = goodsId;
		this.goodsDesc = goodsDesc;
		this.goodsNumber = goodsNumber;
		this.bookingTime = bookingTime;
		this.isDispose = isDispose;
		this.disposeUser = disposeUser;
		this.disposeTime = disposeTime;
		this.disposeNote = disposeNote;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rec_id", unique = true, nullable = false)
	public Long getRecId() {
		return this.recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "link_man", nullable = false, length = 60)
	public String getLinkMan() {
		return this.linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "tel", nullable = false, length = 60)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_desc", nullable = false)
	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	@Column(name = "goods_number", nullable = false)
	public Long getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Long goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "booking_time", nullable = false)
	public Long getBookingTime() {
		return this.bookingTime;
	}

	public void setBookingTime(Long bookingTime) {
		this.bookingTime = bookingTime;
	}

	@Column(name = "is_dispose", nullable = false)
	public Integer getIsDispose() {
		return this.isDispose;
	}

	public void setIsDispose(Integer isDispose) {
		this.isDispose = isDispose;
	}

	@Column(name = "dispose_user", nullable = false, length = 30)
	public String getDisposeUser() {
		return this.disposeUser;
	}

	public void setDisposeUser(String disposeUser) {
		this.disposeUser = disposeUser;
	}

	@Column(name = "dispose_time", nullable = false)
	public Long getDisposeTime() {
		return this.disposeTime;
	}

	public void setDisposeTime(Long disposeTime) {
		this.disposeTime = disposeTime;
	}

	@Column(name = "dispose_note", nullable = false)
	public String getDisposeNote() {
		return this.disposeNote;
	}

	public void setDisposeNote(String disposeNote) {
		this.disposeNote = disposeNote;
	}

}