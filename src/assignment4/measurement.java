package assignment4;

import java.util.*;
import java.time.LocalDateTime;
import java.io.*;
import java.nio.*;
import java.text.SimpleDateFormat;

public class measurement extends ArrayList {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	private LocalDateTime dateTime;

	private double temp;
	private double rain;
	private double wetb;
	private double dewpt;
	private double vappr;
	private double rhum;
	private double msl;
	private double wdsp;
	private double wddir;
	private double sun;

	@Override
	public String toString() {
		return "measurement [dateTime=" + dateTime + "]";
	}
	
	 

	public measurement(LocalDateTime dateTime, double temp, double rain, double wetb, double dewpt, double vappr,
			double rhum, double msl, double wdsp, double wddir, double sun) {
		super();
		this.dateTime = dateTime;
		this.temp = temp;
		this.rain = rain;
		this.wetb = wetb;
		this.dewpt = dewpt;
		this.vappr = vappr;
		this.rhum = rhum;
		this.msl = msl;
		this.wdsp = wdsp;
		this.wddir = wddir;
		this.sun = sun;
	}

	public measurement() {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getRain() {
		return rain;
	}

	public void setRain(double rain) {
		this.rain = rain;
	}

	public double getWetb() {
		return wetb;
	}

	public void setWetb(double wetb) {
		this.wetb = wetb;
	}

	public double getDewpt() {
		return dewpt;
	}

	public void setDewpt(double dewpt) {
		this.dewpt = dewpt;
	}

	public double getVappr() {
		return vappr;
	}

	public void setVappr(double vappr) {
		this.vappr = vappr;
	}

	public double getRhum() {
		return rhum;
	}

	public void setRhum(double rhum) {
		this.rhum = rhum;
	}

	public double getMsl() {
		return msl;
	}

	public void setMsl(double msl) {
		this.msl = msl;
	}

	public double getWdsp() {
		return wdsp;
	}

	public void setWdsp(double wdsp) {
		this.wdsp = wdsp;
	}

	public double getWddir() {
		return wddir;
	}

	public void setWddir(double wddir) {
		this.wddir = wddir;
	}

	public double getSun() {
		return sun;
	}

	public void setSun(double sun) {
		this.sun = sun;
	}

}
