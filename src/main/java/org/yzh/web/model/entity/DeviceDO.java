package org.yzh.web.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

/**
 * @author yezhihao
 * https://gitee.com/yezhihao/jt808-server
 */
public class DeviceDO {

    @Schema(description = "签发日期")
    protected LocalDate issuedAt;
    @Schema(description = "预留字段")
    protected byte reserved;
    @Schema(description = "设备id")
    protected String deviceId;
    @Schema(description = "终端id")
    protected String mobileNo;
    @Schema(description = "机构id")
    protected int agencyId;
    @Schema(description = "司机id")
    protected int driverId;
    @Schema(description = "车辆id")
    protected int vehicleId;
    @Schema(description = "车牌颜色：1.蓝色 2.黄色 3.黑色 4.白色 9.其他")
    protected int plateColor;
    @Schema(description = "车牌号")
    protected String plateNo;
    @Schema(description = "设备型号")
    protected String deviceModel;
    @Schema(description = "协议版本")
    protected int protocolVersion;

    public DeviceDO() {
    }

    public DeviceDO(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDate getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDate issuedAt) {
        this.issuedAt = issuedAt;
    }

    public byte getReserved() {
        return reserved;
    }

    public void setReserved(byte reserved) {
        this.reserved = reserved;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeviceDO{");
        sb.append("issuedAt=").append(issuedAt);
        sb.append(", reserved=").append(reserved);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", mobileNo=").append(mobileNo);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", vehicleId=").append(vehicleId);
        sb.append(", plateColor=").append(plateColor);
        sb.append(", plateNo=").append(plateNo);
        sb.append(", deviceModel=").append(deviceModel);
        sb.append(", protocolVersion=").append(protocolVersion);
        sb.append('}');
        return sb.toString();
    }
}