package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserTrain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_train", catalog = "trainshop")
public class UserTrain implements java.io.Serializable {

	// Fields

	private Long userTrainId;
	private Long userId;
	private String trainNumber;
	private String startTime;
	private String endTime;
	private String carriage;
	private String seatNumber;
	private String seatType;

	// Constructors

	/** default constructor */
	public UserTrain() {
	}

	/** minimal constructor */
	public UserTrain(String trainNumber, String carriage, String seatNumber) {
		this.trainNumber = trainNumber;
		this.carriage = carriage;
		this.seatNumber = seatNumber;
	}

	/** full constructor */
	public UserTrain(Long userId, String trainNumber, String startTime,
			String endTime, String carriage, String seatNumber, String seatType) {
		this.userId = userId;
		this.trainNumber = trainNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.carriage = carriage;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userTrain_id", unique = true, nullable = false)
	public Long getUserTrainId() {
		return this.userTrainId;
	}

	public void setUserTrainId(Long userTrainId) {
		this.userTrainId = userTrainId;
	}

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "train_number", nullable = false, length = 30)
	public String getTrainNumber() {
		return this.trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	@Column(name = "start_time")
	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time")
	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Column(name = "carriage", nullable = false, length = 20)
	public String getCarriage() {
		return this.carriage;
	}

	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}

	@Column(name = "Seat_Number", nullable = false, length = 20)
	public String getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Column(name = "seat_type", length = 20)
	public String getSeatType() {
		return this.seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

}