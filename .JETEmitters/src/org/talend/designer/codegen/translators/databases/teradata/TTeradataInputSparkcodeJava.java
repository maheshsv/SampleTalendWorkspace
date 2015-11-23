package org.talend.designer.codegen.translators.databases.teradata;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tsqlrow.TSqlRowUtil;

public class TTeradataInputSparkcodeJava
{
  protected static String nl;
  public static synchronized TTeradataInputSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataInputSparkcodeJava result = new TTeradataInputSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "public static class ";
  protected final String TEXT_2 = "_FromRowTo";
  protected final String TEXT_3 = " implements org.apache.spark.api.java.function.Function<org.apache.spark.sql.Row, ";
  protected final String TEXT_4 = "> {" + NL + "    java.util.Set<String> fieldsToTrim = new java.util.HashSet<String>();" + NL + "    public ";
  protected final String TEXT_5 = "_FromRowTo";
  protected final String TEXT_6 = "(){";
  protected final String TEXT_7 = NL + "                fieldsToTrim.add(\"";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL + "    }" + NL + "    public ";
  protected final String TEXT_10 = " call(org.apache.spark.sql.Row row) {";
  protected final String TEXT_11 = NL + "        ";
  protected final String TEXT_12 = " result = new ";
  protected final String TEXT_13 = "();" + NL + "        org.apache.spark.sql.types.StructField[] structFields = row.schema().fields();" + NL + "        for (int i = 0; i < structFields.length; i++) {" + NL + "            org.apache.avro.Schema.Field avroField = ";
  protected final String TEXT_14 = ".getClassSchema().getField(structFields[i].name());" + NL + "            if (avroField != null){" + NL + "                if (structFields[i].dataType().equals(org.apache.spark.sql.types.DataTypes.StringType)" + NL + "                        && (";
  protected final String TEXT_15 = " || fieldsToTrim.contains(structFields[i].name()))) {" + NL + "                    result.put(avroField.pos(), ((String) row.get(i)).trim());" + NL + "                } else {" + NL + "                    result.put(avroField.pos(), row.get(i));" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        return result;" + NL + "    }" + NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
// We use the tSQLRowUtilFUnction to get the generator of Row->Struct function
TSqlRowUtil tSqlRowUtil = new TSqlRowUtil(node);
String outStructName = codeGenArgument.getRecordStructName(tSqlRowUtil.getOutgoingConnection());

boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_6);
    
        for(Map<String, String> trimColumn : trimColumnList) {
            if(("true").equals(trimColumn.get("TRIM"))) {
                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(trimColumn.get("SCHEMA_COLUMN"));
    stringBuffer.append(TEXT_8);
    
            }
        }
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(whetherTrimAllCol);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
