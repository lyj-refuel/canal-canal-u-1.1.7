package com.alibaba.otter.canal.client.adapter.support;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DML操作转换对象
 *
 * @author rewerma 2018-8-19 下午11:30:49
 * @version 1.0.0
 */
public class Dml implements Serializable {

    private static final long         serialVersionUID = 2611556444074013268L;

    private String                    destination;                            // 对应canal的实例或者MQ的topic
    private String                    groupId;                                // 对应mq的group id
    private String                    database;                               // 数据库或schema
    private String                    table;                                  // 表名
    private List<String>              pkNames;
    private Boolean                   isDdl;
    private String                    type;                                   // 类型: INSERT UPDATE DELETE
    // binlog executeTime
    private Long                      es;                                     // 执行耗时
    // dml build timeStamp
    private Long                      ts;                                     // 同步时间
    private String                    sql;                                    // 执行的sql, dml sql为空
    private List<Map<String, Object>> data;                                   // 数据列表
    private List<Map<String, Object>> old;                                    // 旧数据列表, 用于update, size和data的size一一对应

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<String> getPkNames() {
        return pkNames;
    }

    public void setPkNames(List<String> pkNames) {
        this.pkNames = pkNames;
    }

    public Boolean getIsDdl() {
        return isDdl;
    }

    public void setIsDdl(Boolean isDdl) {
        this.isDdl = isDdl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public List<Map<String, Object>> getOld() {
        return old;
    }

    public void setOld(List<Map<String, Object>> old) {
        this.old = old;
    }

    public Long getEs() {
        return es;
    }

    public void setEs(Long es) {
        this.es = es;
    }

    public void clear() {
        database = null;
        table = null;
        type = null;
        ts = null;
        es = null;
        data = null;
        old = null;
        sql = null;
    }

//    @Override
//    public String toString() {
//        return "Dml{" + "destination='" + destination + '\'' + ", database='" + database + '\'' + ", table='" + table
//               + '\'' + ", type='" + type + '\'' + ", es=" + es + ", ts=" + ts + ", sql='" + sql + '\'' + ", data="
//               + data + ", old=" + old + '}';
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dml{");

        // 输出destination属性
        sb.append("destination='").append(destination).append('\'');
        sb.append(", ");

        // 输出groupId属性
        sb.append("groupId='").append(groupId).append('\'');
        sb.append(", ");

        // 输出database属性
        sb.append("database='").append(database).append('\'');
        sb.append(", ");

        // 输出table属性
        sb.append("table='").append(table).append('\'');
        sb.append(", ");

        // 输出pkNames属性，对列表进行格式化输出
        sb.append("pkNames=[");
        if (pkNames!= null) {
            for (int i = 0; i < pkNames.size(); i++) {
                sb.append(pkNames.get(i));
                if (i < pkNames.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("], ");

        // 输出isDdl属性
        sb.append("isDdl=").append(isDdl);
        sb.append(", ");

        // 输出type属性
        sb.append("type='").append(type).append('\'');
        sb.append(", ");

        // 输出es属性
        sb.append("es=").append(es);
        sb.append(", ");

        // 输出ts属性
        sb.append("ts=").append(ts);
        sb.append(", ");

        // 输出sql属性
        sb.append("sql='").append(sql).append('\'');
        sb.append(", ");

        // 输出data属性，对列表中的Map进行格式化输出（简单示例，可根据实际需求进一步优化格式）
        sb.append("data=[");
        if (data!= null) {
            for (int i = 0; i < data.size(); i++) {
                Map<String, Object> map = data.get(i);
                sb.append(map.toString());
                if (i < data.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("], ");

        // 输出old属性，同样对列表中的Map进行格式化输出
        sb.append("old=[");
        if (old!= null) {
            for (int i = 0; i < old.size(); i++) {
                Map<String, Object> map = old.get(i);
                sb.append(map.toString());
                if (i < old.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");

        sb.append('}');
        return sb.toString();
    }
}
