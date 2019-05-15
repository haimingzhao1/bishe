package com.bm.model;

public class TStudentDomain {

        private Integer id;

        private String stuNumber;

        private String stuName;

        private Integer gender;

        private String stuPhone;

        private TDiscipline discipline;

        private Integer count;

        private Integer isVip;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStuNumber() {
            return stuNumber;
        }

        public void setStuNumber(String stuNumber) {
            this.stuNumber = stuNumber == null ? null : stuNumber.trim();
        }

        public String getStuName() {
            return stuName;
        }

        public void setStuName(String stuName) {
            this.stuName = stuName == null ? null : stuName.trim();
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getStuPhone() {
            return stuPhone;
        }

        public void setStuPhone(String stuPhone) {
            this.stuPhone = stuPhone == null ? null : stuPhone.trim();
        }

        public TDiscipline getDiscipline() {
            return discipline;
        }

        public void setDiscipline(TDiscipline discipline) {
            this.discipline = discipline;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getIsVip() {
            return isVip;
        }

        public void setIsVip(Integer isVip) {
            this.isVip = isVip;
        }

}
