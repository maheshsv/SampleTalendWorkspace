package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THDFSRowCountMainJava
{
  protected static String nl;
  public static synchronized THDFSRowCountMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSRowCountMainJava result = new THDFSRowCountMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_7 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_10 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_13 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_15 = " - Written records count: \" + nb_line_";
  protected final String TEXT_16 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_18 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_20 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_21 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_23 = " - Writing the record \" + nb_line_";
  protected final String TEXT_24 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Processing the record \" + nb_line_";
  protected final String TEXT_27 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_29 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_30 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "String username_";
  protected final String TEXT_33 = " = \"\";" + NL + "org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_34 = " = null;";
  protected final String TEXT_35 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_36 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconf_";
  protected final String TEXT_37 = ".set(\"";
  protected final String TEXT_38 = "\", ";
  protected final String TEXT_39 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_40 = NL + "        conf_";
  protected final String TEXT_41 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_42 = NL + "\t\t\tconf_";
  protected final String TEXT_43 = ".set(";
  protected final String TEXT_44 = " ,";
  protected final String TEXT_45 = ");" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\tconf_";
  protected final String TEXT_47 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "    \tconf_";
  protected final String TEXT_53 = ".set(\"hadoop.job.ugi\",";
  protected final String TEXT_54 = "+\",\"+";
  protected final String TEXT_55 = ");" + NL + "    \tfs_";
  protected final String TEXT_56 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_57 = ");" + NL + "\t";
  protected final String TEXT_58 = NL + "\t\tusername_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_61 = " == null || \"\".equals(username_";
  protected final String TEXT_62 = ")){" + NL + "\t\t\tfs_";
  protected final String TEXT_63 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_64 = ");" + NL + "\t\t}else{" + NL + "\t\t\tfs_";
  protected final String TEXT_65 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_66 = ".get(\"";
  protected final String TEXT_67 = "\")),conf_";
  protected final String TEXT_68 = ",username_";
  protected final String TEXT_69 = ");" + NL + "\t\t}\t" + NL + "\t";
  protected final String TEXT_70 = NL + "\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_71 = " = (org.apache.hadoop.conf.Configuration)globalMap.get(\"conn_";
  protected final String TEXT_72 = "\");" + NL + "\t";
  protected final String TEXT_73 = NL + "\t\t    \tfs_";
  protected final String TEXT_74 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\tconf_";
  protected final String TEXT_77 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t\t\tusername_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\tif(username_";
  protected final String TEXT_82 = " == null || \"\".equals(username_";
  protected final String TEXT_83 = ")){" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_84 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_85 = ");" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tfs_";
  protected final String TEXT_86 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_87 = ".get(\"";
  protected final String TEXT_88 = "\")),conf_";
  protected final String TEXT_89 = ",username_";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t}\t\t\t  \t\t" + NL + "\t\t  \t";
  protected final String TEXT_91 = NL + "\t\t";
  protected final String TEXT_92 = NL + "\t  String filename_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";" + NL + "\t  int emptyLineCount_";
  protected final String TEXT_95 = " = 0;" + NL + "\t  org.apache.hadoop.fs.Path file_";
  protected final String TEXT_96 = " = new org.apache.hadoop.fs.Path(filename_";
  protected final String TEXT_97 = ");" + NL + "\t  org.apache.hadoop.fs.FSDataInputStream fsdis_";
  protected final String TEXT_98 = " = fs_";
  protected final String TEXT_99 = ".open(file_";
  protected final String TEXT_100 = ");" + NL + "\t" + NL + "\t  int lineCount_";
  protected final String TEXT_101 = " = 0;" + NL + "\t  " + NL + "\t  ";
  protected final String TEXT_102 = NL + "\t  \tjava.io.BufferedReader br_";
  protected final String TEXT_103 = " = new java.io.BufferedReader(new java.io.InputStreamReader(fsdis_";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = "));" + NL + "\t  ";
  protected final String TEXT_106 = NL + "\t    org.apache.hadoop.io.compress.GzipCodec codec_";
  protected final String TEXT_107 = " = new org.apache.hadoop.io.compress.GzipCodec();" + NL + "\t\tcodec_";
  protected final String TEXT_108 = ".setConf(conf_";
  protected final String TEXT_109 = ");\t" + NL + "\t  ";
  protected final String TEXT_110 = NL + "\t  \torg.apache.hadoop.io.compress.CompressionCodec codec_";
  protected final String TEXT_111 = " = org.apache.hadoop.util.ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class, conf_";
  protected final String TEXT_112 = ");" + NL + "\t  ";
  protected final String TEXT_113 = NL + "\t  \torg.apache.hadoop.io.compress.CompressionInputStream in";
  protected final String TEXT_114 = " = codec_";
  protected final String TEXT_115 = ".createInputStream(fsdis_";
  protected final String TEXT_116 = ");" + NL + "\t  \tjava.io.BufferedReader br_";
  protected final String TEXT_117 = " = new java.io.BufferedReader(new java.io.InputStreamReader(in";
  protected final String TEXT_118 = ", ";
  protected final String TEXT_119 = "));" + NL + "\t  ";
  protected final String TEXT_120 = NL + "\t  " + NL + "\t  \t\t\t" + NL + "\t  String rowSeparator_";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = ";" + NL + "\t  byte[] bytes_";
  protected final String TEXT_123 = " = rowSeparator_";
  protected final String TEXT_124 = ".getBytes();" + NL + "\t  int index_";
  protected final String TEXT_125 = " = 0, oneChar_";
  protected final String TEXT_126 = " = 0, tipEmptyLineCount_";
  protected final String TEXT_127 = " = 0; " + NL + "\t  boolean bTipEmptyFlagOpen_";
  protected final String TEXT_128 = " = true, bReadyEOF_";
  protected final String TEXT_129 = " = false;" + NL + "\t\t\t" + NL + "\t  if(bytes_";
  protected final String TEXT_130 = ".length > 0) {" + NL + "\t    while ((oneChar_";
  protected final String TEXT_131 = " = br_";
  protected final String TEXT_132 = ".read()) != -1) {" + NL + "\t      if (oneChar_";
  protected final String TEXT_133 = " == bytes_";
  protected final String TEXT_134 = "[index_";
  protected final String TEXT_135 = "]) {" + NL + "\t      " + NL + "\t        if (index_";
  protected final String TEXT_136 = " < bytes_";
  protected final String TEXT_137 = ".length - 1){" + NL + "\t          index_";
  protected final String TEXT_138 = " ++ ;" + NL + "\t          continue; // match next char" + NL + "\t        }" + NL + "\t        " + NL + "\t        if (index_";
  protected final String TEXT_139 = " == bytes_";
  protected final String TEXT_140 = ".length - 1) {                  " + NL + "\t          lineCount_";
  protected final String TEXT_141 = "++;" + NL + "\t          if(bTipEmptyFlagOpen_";
  protected final String TEXT_142 = ") {" + NL + "\t            tipEmptyLineCount_";
  protected final String TEXT_143 = " ++;" + NL + "\t            emptyLineCount_";
  protected final String TEXT_144 = " ++;" + NL + "\t          }" + NL + "\t          bReadyEOF_";
  protected final String TEXT_145 = " = false; // next row must be have char(or EOF flag)" + NL + "\t          bTipEmptyFlagOpen_";
  protected final String TEXT_146 = " = true; " + NL + "\t          index_";
  protected final String TEXT_147 = " = 0;" + NL + "\t        }" + NL + "\t        " + NL + "\t      }else{      " + NL + "\t        bReadyEOF_";
  protected final String TEXT_148 = " = true;" + NL + "\t        bTipEmptyFlagOpen_";
  protected final String TEXT_149 = " = false;" + NL + "\t        tipEmptyLineCount_";
  protected final String TEXT_150 = " = 0;" + NL + "\t        index_";
  protected final String TEXT_151 = " = 0;        " + NL + "\t      }" + NL + "\t    }" + NL + "\t    " + NL + "\t    if (bReadyEOF_";
  protected final String TEXT_152 = ") lineCount_";
  protected final String TEXT_153 = " ++ ; // add last row if not end by row separator" + NL + "\t    " + NL + "\t    if (bTipEmptyFlagOpen_";
  protected final String TEXT_154 = ") {" + NL + "\t      lineCount_";
  protected final String TEXT_155 = " -= tipEmptyLineCount_";
  protected final String TEXT_156 = ";" + NL + "\t      emptyLineCount_";
  protected final String TEXT_157 = " -= tipEmptyLineCount_";
  protected final String TEXT_158 = ";" + NL + "\t    }          " + NL + "\t  }" + NL + "\t  br_";
  protected final String TEXT_159 = ".close();" + NL + "\t";
  protected final String TEXT_160 = NL + "  \tlineCount_";
  protected final String TEXT_161 = " -= emptyLineCount_";
  protected final String TEXT_162 = ";" + NL + "\t";
  protected final String TEXT_163 = "   " + NL + "  \tglobalMap.put(\"";
  protected final String TEXT_164 = "_COUNT\",lineCount_";
  protected final String TEXT_165 = ");" + NL + "  \t" + NL + "\t";
  protected final String TEXT_166 = NL + "\tlog.info(\"";
  protected final String TEXT_167 = " - file : \" + file_";
  protected final String TEXT_168 = " + \" line count is \" + lineCount_";
  protected final String TEXT_169 = ");" + NL + "\t";
  protected final String TEXT_170 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_8);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_19);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_21);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_22);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_28);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_31);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
String user = null;

String fsDefalutName = "fs.default.name";

String hadoopVersion = null;
boolean isCustom = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

log4jFileUtil.componentStartInfo(node);

java.util.List<String> supportKrbVersionList = java.util.Arrays.<String>asList(
	"Cloudera_CDH4","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1",
	"HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1","HDP_2_2",
	"APACHE_1_0_0","APACHE_1_0_3_EMR",
	"PIVOTAL_HD_2_0"
);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
if(!useExistingConnection) { // if we don't use an existing connection, we create a new hadoop configuration
	hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
    boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
	
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	isCustom = "CUSTOM".equals(distribution);
	String auth = ElementParameterParser.getValue(node, "__AUTHENTICATION_MODE__");
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_39);
    
	if (mrUseDatanodeHostname) {
        
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
    }
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){
		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_45);
     
		}
	}
	
	if(!(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && useKrb && !isCustom)
	   || (isCustom && "KRB".equals(auth)))) {
		user = ElementParameterParser.getValue(node, "__USERNAME__");
	} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_48);
    
		if(useKeytab) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_51);
    
		}
	}
	
	if("MAPR".equals(distribution) || (isCustom && "UGI".equals(auth))){
		String group = ElementParameterParser.getValue(node, "__GROUP__");
	
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
	}else{
	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	}
	
} else { // We re use the existing connection, coming from the component learned.
	String connectionSid = ElementParameterParser.getValue(node, "__CONNECTION__");
	
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connectionSid);
    stringBuffer.append(TEXT_72);
    
	List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
		if (targetNode.getUniqueName().equals(connectionSid)) {
        	hadoopVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__"); 
    		boolean useKrb = "true".equals(ElementParameterParser.getValue(targetNode, "__USE_KRB__"));
    		String kerberosPrincipal = ElementParameterParser.getValue(targetNode, "__NAMENODE_PRINCIPAL__");
    		
    		String distribution = ElementParameterParser.getValue(targetNode, "__DISTRIBUTION__");
    		isCustom = "CUSTOM".equals(distribution);
    		String auth = ElementParameterParser.getValue(targetNode, "__AUTHENTICATION_MODE__");
		
	      	if("MAPR".equals(distribution) || (isCustom && "UGI".equals(auth))){
		    
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		  	}else{
				if(!(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && !isCustom && useKrb) || (isCustom && "KRB".equals(auth)))) {
					user = ElementParameterParser.getValue(targetNode, "__USERNAME__");
				} else {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_78);
    
				}
			  	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
		  	}
	      	break;
	    }
    }
}

    stringBuffer.append(TEXT_91);
    	
	 String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	 String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
	 String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	 boolean ignoreEmptyRow = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_EMPTY_ROW__"));
	
	 boolean uncompress = "true".equals(ElementParameterParser.getValue(node, "__UNCOMPRESS__"));
	 String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
	  if(!uncompress) {
	  
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_105);
    
	  } else {
	  	if("GZIP".equals(compression)) {
	  
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
	  	} else if("BZIP2".equals(compression)) {
	  
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
	  	}
	  
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_119);
    
	  }
	  
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    
  	if (ignoreEmptyRow){
	
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    
	if(isLog4jEnabled) {
	
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    
	}
	
	
    stringBuffer.append(TEXT_170);
    return stringBuffer.toString();
  }
}
