package com.kzk.kcloud.config;


public class DruidDataSourceProperties {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getLogSlowSql() {
        return logSlowSql;
    }

    public void setLogSlowSql(String logSlowSql) {
        this.logSlowSql = logSlowSql;
    }

    //    @Value("${spring.datasource.url}")
    private String url;

    //    @Value("${spring.datasource.type}")
    private String type;

    //    @Value("${loginUsername}")
    private String loginUsername;

    //    @Value("${loginPassword}")
    private String loginPassword;

    //    @Value("${spring.datasource.username}")
    private String username;

    //    @Value("${spring.datasource.password}")
    private String password;

    //    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    //    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    //    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    //    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    //    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    //    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    //    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    //    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    //    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    //    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    //    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    //    @Value("${spring.datasource.filters}")
    private String filters;

    //    @Value("${spring.datasource.logSlowSql}")
    private String logSlowSql;


}
