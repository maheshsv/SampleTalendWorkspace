package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMCommitMainJava
{
  protected static String nl;
  public static synchronized TMDMCommitMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMCommitMainJava result = new TMDMCommitMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "    org.talend.mdm.webservice.TMDMService_PortType conn_";
  protected final String TEXT_4 = " = (org.talend.mdm.webservice.TMDMService_PortType)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "    " + NL + "    if(conn_";
  protected final String TEXT_6 = " != null)" + NL + "    {" + NL + "    \tcom.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_7 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(\"";
  protected final String TEXT_8 = "\");" + NL + "    \tif(mdmTransaction_";
  protected final String TEXT_9 = "!=null) {" + NL + "    \t\tmdmTransaction_";
  protected final String TEXT_10 = ".commit();" + NL + "    \t}";
  protected final String TEXT_11 = NL + "        conn_";
  protected final String TEXT_12 = ".logout(new org.talend.mdm.webservice.WSLogout());";
  protected final String TEXT_13 = NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));

    String mdmTransaction = "mdmTransaction_" + connection;
	
	String conn = "";

    stringBuffer.append(TEXT_2);
    conn = "TMDMService_" + connection;
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mdmTransaction);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
      if(close){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
     }
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
