package org.talend.designer.codegen.translators.data_quality.address.experianqas;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;

public class TQASAddressRowBeginJava
{
  protected static String nl;
  public static synchronized TQASAddressRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TQASAddressRowBeginJava result = new TQASAddressRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "com.talend.qas.QASClient qasClient_";
  protected final String TEXT_4 = " = new com.talend.qas.QASClient(";
  protected final String TEXT_5 = ", \"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    String wsdlAddress = ElementParameterParser.getValue(node, "__WSDL_ADDRESS__");
    String country = ElementParameterParser.getValue(node, "__COUNTRY__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( wsdlAddress );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( country );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
