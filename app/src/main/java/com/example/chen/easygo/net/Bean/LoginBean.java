package com.example.chen.easygo.net.Bean;

import com.example.chen.easygo.net.myHttp.BaseResponse;

/**
 * Created by Chen on 2018/11/13.
 */

public class LoginBean extends BaseResponse {
    /**
     * data : {"driver":{"id":10000004,"profileId":6,"sequenceNumber":30000012,"promotionCode":"S30000012","carId":80,"grade":1,"driverName":"罗旺","identityNumber":"430211198509111073","age":33,"driverLicenseNumber":"440782198905114717","allowCarType":"C1","firstIssueDate":"20120229","iconUrl":"https://cos.0voice.com/community/profile_150.png","mobile":"18874864639","password":null,"cityCode":430100,"cityName":"长沙","location":"28.201013,112.982982","identityCardFrontUrl":null,"identityCardReverseUrl":null,"driverLicenseFrontUrl":null,"driverLicenseReverseUrl":null,"drivingPermitFrontUrl":null,"drivingPermitReverseUrl":null,"drivingPermitDuplicateUrl":null,"personCardUrl":null,"personCarUrl":null,"createTime":null},"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZW1iZXJfaWQiOiIxMDAwMDAwNCIsImF1ZCI6IkFQUCIsImlzcyI6IlNlcnZpY2UiLCJleHAiOjE1NDIxMTgyNDcsImlhdCI6MTU0MjExODIzN30.a85azRd8qxd1vojQGK3K86758oe8vBCbAsm-R3lo0Ig"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * driver : {"id":10000004,"profileId":6,"sequenceNumber":30000012,"promotionCode":"S30000012","carId":80,"grade":1,"driverName":"罗旺","identityNumber":"430211198509111073","age":33,"driverLicenseNumber":"440782198905114717","allowCarType":"C1","firstIssueDate":"20120229","iconUrl":"https://cos.0voice.com/community/profile_150.png","mobile":"18874864639","password":null,"cityCode":430100,"cityName":"长沙","location":"28.201013,112.982982","identityCardFrontUrl":null,"identityCardReverseUrl":null,"driverLicenseFrontUrl":null,"driverLicenseReverseUrl":null,"drivingPermitFrontUrl":null,"drivingPermitReverseUrl":null,"drivingPermitDuplicateUrl":null,"personCardUrl":null,"personCarUrl":null,"createTime":null}
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZW1iZXJfaWQiOiIxMDAwMDAwNCIsImF1ZCI6IkFQUCIsImlzcyI6IlNlcnZpY2UiLCJleHAiOjE1NDIxMTgyNDcsImlhdCI6MTU0MjExODIzN30.a85azRd8qxd1vojQGK3K86758oe8vBCbAsm-R3lo0Ig
         */

        private DriverBean driver;
        private String token;

        public DriverBean getDriver() {
            return driver;
        }

        public void setDriver(DriverBean driver) {
            this.driver = driver;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class DriverBean {
            /**
             * id : 10000004
             * profileId : 6
             * sequenceNumber : 30000012
             * promotionCode : S30000012
             * carId : 80
             * grade : 1
             * driverName : 罗旺
             * identityNumber : 430211198509111073
             * age : 33
             * driverLicenseNumber : 440782198905114717
             * allowCarType : C1
             * firstIssueDate : 20120229
             * iconUrl : https://cos.0voice.com/community/profile_150.png
             * mobile : 18874864639
             * password : null
             * cityCode : 430100
             * cityName : 长沙
             * location : 28.201013,112.982982
             * identityCardFrontUrl : null
             * identityCardReverseUrl : null
             * driverLicenseFrontUrl : null
             * driverLicenseReverseUrl : null
             * drivingPermitFrontUrl : null
             * drivingPermitReverseUrl : null
             * drivingPermitDuplicateUrl : null
             * personCardUrl : null
             * personCarUrl : null
             * createTime : null
             */

            private int id;
            private int profileId;
            private int sequenceNumber;
            private String promotionCode;
            private int carId;
            private int grade;
            private String driverName;
            private String identityNumber;
            private int age;
            private String driverLicenseNumber;
            private String allowCarType;
            private String firstIssueDate;
            private String iconUrl;
            private String mobile;
            private Object password;
            private int cityCode;
            private String cityName;
            private String location;
            private Object identityCardFrontUrl;
            private Object identityCardReverseUrl;
            private Object driverLicenseFrontUrl;
            private Object driverLicenseReverseUrl;
            private Object drivingPermitFrontUrl;
            private Object drivingPermitReverseUrl;
            private Object drivingPermitDuplicateUrl;
            private Object personCardUrl;
            private Object personCarUrl;
            private Object createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProfileId() {
                return profileId;
            }

            public void setProfileId(int profileId) {
                this.profileId = profileId;
            }

            public int getSequenceNumber() {
                return sequenceNumber;
            }

            public void setSequenceNumber(int sequenceNumber) {
                this.sequenceNumber = sequenceNumber;
            }

            public String getPromotionCode() {
                return promotionCode;
            }

            public void setPromotionCode(String promotionCode) {
                this.promotionCode = promotionCode;
            }

            public int getCarId() {
                return carId;
            }

            public void setCarId(int carId) {
                this.carId = carId;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public String getDriverName() {
                return driverName;
            }

            public void setDriverName(String driverName) {
                this.driverName = driverName;
            }

            public String getIdentityNumber() {
                return identityNumber;
            }

            public void setIdentityNumber(String identityNumber) {
                this.identityNumber = identityNumber;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getDriverLicenseNumber() {
                return driverLicenseNumber;
            }

            public void setDriverLicenseNumber(String driverLicenseNumber) {
                this.driverLicenseNumber = driverLicenseNumber;
            }

            public String getAllowCarType() {
                return allowCarType;
            }

            public void setAllowCarType(String allowCarType) {
                this.allowCarType = allowCarType;
            }

            public String getFirstIssueDate() {
                return firstIssueDate;
            }

            public void setFirstIssueDate(String firstIssueDate) {
                this.firstIssueDate = firstIssueDate;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public int getCityCode() {
                return cityCode;
            }

            public void setCityCode(int cityCode) {
                this.cityCode = cityCode;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public Object getIdentityCardFrontUrl() {
                return identityCardFrontUrl;
            }

            public void setIdentityCardFrontUrl(Object identityCardFrontUrl) {
                this.identityCardFrontUrl = identityCardFrontUrl;
            }

            public Object getIdentityCardReverseUrl() {
                return identityCardReverseUrl;
            }

            public void setIdentityCardReverseUrl(Object identityCardReverseUrl) {
                this.identityCardReverseUrl = identityCardReverseUrl;
            }

            public Object getDriverLicenseFrontUrl() {
                return driverLicenseFrontUrl;
            }

            public void setDriverLicenseFrontUrl(Object driverLicenseFrontUrl) {
                this.driverLicenseFrontUrl = driverLicenseFrontUrl;
            }

            public Object getDriverLicenseReverseUrl() {
                return driverLicenseReverseUrl;
            }

            public void setDriverLicenseReverseUrl(Object driverLicenseReverseUrl) {
                this.driverLicenseReverseUrl = driverLicenseReverseUrl;
            }

            public Object getDrivingPermitFrontUrl() {
                return drivingPermitFrontUrl;
            }

            public void setDrivingPermitFrontUrl(Object drivingPermitFrontUrl) {
                this.drivingPermitFrontUrl = drivingPermitFrontUrl;
            }

            public Object getDrivingPermitReverseUrl() {
                return drivingPermitReverseUrl;
            }

            public void setDrivingPermitReverseUrl(Object drivingPermitReverseUrl) {
                this.drivingPermitReverseUrl = drivingPermitReverseUrl;
            }

            public Object getDrivingPermitDuplicateUrl() {
                return drivingPermitDuplicateUrl;
            }

            public void setDrivingPermitDuplicateUrl(Object drivingPermitDuplicateUrl) {
                this.drivingPermitDuplicateUrl = drivingPermitDuplicateUrl;
            }

            public Object getPersonCardUrl() {
                return personCardUrl;
            }

            public void setPersonCardUrl(Object personCardUrl) {
                this.personCardUrl = personCardUrl;
            }

            public Object getPersonCarUrl() {
                return personCarUrl;
            }

            public void setPersonCarUrl(Object personCarUrl) {
                this.personCarUrl = personCarUrl;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }
        }
    }
}
