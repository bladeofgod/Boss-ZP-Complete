package com.bedrock.boss_zp.model;

public class JobBean {

    String jobName;
    String companyName;
    String salary;
    String recruiter;

    public JobBean(){
        jobName = "";
        companyName = "";
        salary = "";
        recruiter = "";
    }

    public JobBean(String jobName, String companyName, String salary, String recruiter) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.salary = salary;
        this.recruiter = recruiter;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String recruiter) {
        this.recruiter = recruiter;
    }
}
