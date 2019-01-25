package cn.reasonwhy.spring.mybatis;

import java.lang.reflect.Field;

public class SqlProviderAdapter {
    public String updateByPrimaryKeySelective(Object obj) {
        String sql = "UPDATE %s SET %s WHERE id = #{id}";
        String className = obj.getClass().getSimpleName();
        String tableName = className.replaceAll("([A-Z])", "_$1").toLowerCase().substring(1);
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder setSb = new StringBuilder();
        for (Field field : fields) {
            String filedName = field.getName();
            if ("id".equals(filedName)) {
                continue;
            }
            Object value;
            try {
                field.setAccessible(true);
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (value == null) {
                continue;
            }
            String snakeName = filedName.replaceAll("([A-Z])", "_$1").toLowerCase();
            setSb.append(snakeName).append("=#{").append(filedName).append("}").append(",");
        }
        setSb.deleteCharAt(setSb.length() - 1);
        return String.format(sql, tableName, setSb.toString());
    }

    public String insertSelective(Object obj) {
        String sql = "INSERT INTO %s (%s) VALUES (%s)";
        String className = obj.getClass().getSimpleName();
        String tableName = className.replaceAll("([A-Z])", "_$1").toLowerCase().substring(1);
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder valuesSb = new StringBuilder();
        StringBuilder fieldsSb = new StringBuilder();
        for (Field field : fields) {
            String fieldName = field.getName();
            Object value;
            try {
                field.setAccessible(true);
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (value == null) {
                continue;
            }
            String snakeName = fieldName.replaceAll("([A-Z])", "_$1").toLowerCase();
            fieldsSb.append(snakeName).append(",");
            valuesSb.append("#{").append(fieldName).append("}").append(",");
        }
        fieldsSb.deleteCharAt(fieldsSb.length() - 1);
        valuesSb.deleteCharAt(valuesSb.length() - 1);
        return String.format(sql, tableName, fieldsSb.toString(), valuesSb.toString());
    }
}
