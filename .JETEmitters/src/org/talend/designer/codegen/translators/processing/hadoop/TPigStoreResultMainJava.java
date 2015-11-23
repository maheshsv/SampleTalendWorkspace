package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;
import org.talend.core.model.utils.NodeUtil;

public class TPigStoreResultMainJava
{
  protected static String nl;
  public static synchronized TPigStoreResultMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigStoreResultMainJava result = new TPigStoreResultMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_8 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_11 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Written records count: \" + nb_line_";
  protected final String TEXT_17 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_19 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_22 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Writing the record \" + nb_line_";
  protected final String TEXT_25 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processing the record \" + nb_line_";
  protected final String TEXT_28 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_31 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t" + NL + "\t";
  protected final String TEXT_33 = NL + "            String decryptedS3Password_";
  protected final String TEXT_34 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "            String decryptedS3Password_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = "; ";
  protected final String TEXT_39 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_40 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_41 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister(\"../../job.xml\");" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_43 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = "\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tpublic boolean setJarsToRegister(String filename) throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(filename).getCanonicalPath();" + NL + "\t\t\t\tif(isNeedAddLibsPath(jobXmlPath)) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\tGetJarsToRegister_";
  protected final String TEXT_45 = " getJarsToRegister_";
  protected final String TEXT_46 = " = new GetJarsToRegister_";
  protected final String TEXT_47 = "();";
  protected final String TEXT_48 = NL + "\t\t    if (pigServer_";
  protected final String TEXT_49 = ".existsFile(\"s3n://\" + ";
  protected final String TEXT_50 = " + \":\" + decryptedS3Password_";
  protected final String TEXT_51 = " + \"@\" + ";
  protected final String TEXT_52 = ")) {" + NL + "\t            pigServer_";
  protected final String TEXT_53 = ".deleteFile(\"s3n://\" + ";
  protected final String TEXT_54 = " + \":\" + decryptedS3Password_";
  protected final String TEXT_55 = " + \"@\" + ";
  protected final String TEXT_56 = ");" + NL + "\t        }";
  protected final String TEXT_57 = NL + "    \t\tif (pigServer_";
  protected final String TEXT_58 = ".existsFile(";
  protected final String TEXT_59 = ")) {" + NL + "    \t\t\tpigServer_";
  protected final String TEXT_60 = ".deleteFile(";
  protected final String TEXT_61 = ");" + NL + "        \t}";
  protected final String TEXT_62 = NL + NL + "\t\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_63 = " = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t\t+ \"AccountName=\"" + NL + "\t\t\t\t+ instance_";
  protected final String TEXT_64 = ".getAzureAccountName()" + NL + "\t\t\t\t+ \";\"" + NL + "\t\t\t\t+ \"AccountKey=\" + instance_";
  protected final String TEXT_65 = ".getAzureAccountPassword(), instance_";
  protected final String TEXT_66 = ".getAzureAccountContainer());" + NL + "\t\t\t" + NL + "\t\t\tString resultFolder_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ";" + NL + "\t\t\tazureFs_";
  protected final String TEXT_69 = ".delete(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(resultFolder_";
  protected final String TEXT_70 = "));";
  protected final String TEXT_71 = NL + "\t" + NL + "\troutines.system.PigHelper helper_";
  protected final String TEXT_72 = " = new routines.system.PigHelper();" + NL + "\t" + NL + "\tStringBuilder sb_";
  protected final String TEXT_73 = " = new StringBuilder();";
  protected final String TEXT_74 = NL + "\t\t\t\t\thelper_";
  protected final String TEXT_75 = ".add(\"jar\",getJarsToRegister_";
  protected final String TEXT_76 = ".replaceJarPaths(\"";
  protected final String TEXT_77 = "\"));";
  protected final String TEXT_78 = NL + "\t\t\t\t\thelper_";
  protected final String TEXT_79 = ".add(\"jar\",";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\tSystem.setProperty(\"hive.metastore.uris\", ";
  protected final String TEXT_82 = ");" + NL + "\t\tSystem.setProperty(\"hadoop.clientside.fs.operations\", \"true\");" + NL + "\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\tsb_";
  protected final String TEXT_83 = ".append(\"STORE ";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = "_RESULT INTO '\"+";
  protected final String TEXT_86 = "+\".\"+";
  protected final String TEXT_87 = "+\"' using ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = "('\"+";
  protected final String TEXT_90 = "+\"'\");";
  protected final String TEXT_91 = NL + "\t\t\t\tsb_";
  protected final String TEXT_92 = ".append(\" , '\");";
  protected final String TEXT_93 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_94 = ".append(\"";
  protected final String TEXT_95 = ":";
  protected final String TEXT_96 = "\");";
  protected final String TEXT_97 = NL + "\t\t\t\tsb_";
  protected final String TEXT_98 = ".append(\"'\");";
  protected final String TEXT_99 = NL + "\t\tsb_";
  protected final String TEXT_100 = ".append(\");\");";
  protected final String TEXT_101 = NL + "            sb_";
  protected final String TEXT_102 = ".append(\"STORE ";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = "_RESULT INTO '\"" + NL + "                    + \"s3n://\" + ";
  protected final String TEXT_105 = " + \":\" + decryptedS3Password_";
  protected final String TEXT_106 = " + \"@\" + ";
  protected final String TEXT_107 = NL + "                    + \"' using com.twitter.elephantbird.pig.store.SequenceFileStorage('-c ";
  protected final String TEXT_108 = "','-c ";
  protected final String TEXT_109 = "');\");";
  protected final String TEXT_110 = NL + "            sb_";
  protected final String TEXT_111 = ".append(\"STORE ";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = "_RESULT INTO '\" + ";
  protected final String TEXT_114 = NL + "                    + \"' using com.twitter.elephantbird.pig.store.SequenceFileStorage('-c ";
  protected final String TEXT_115 = "','-c ";
  protected final String TEXT_116 = "');\");";
  protected final String TEXT_117 = NL + "\t\t        sb_";
  protected final String TEXT_118 = ".append(\"STORE ";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = "_RESULT INTO '\"" + NL + "\t\t                + \"s3n://\" + ";
  protected final String TEXT_121 = " + \":\" + decryptedS3Password_";
  protected final String TEXT_122 = " + \"@\" + ";
  protected final String TEXT_123 = NL + "\t\t                + \"' using \" + ";
  protected final String TEXT_124 = " + \";\");";
  protected final String TEXT_125 = NL + "\t\t        sb_";
  protected final String TEXT_126 = ".append(\"STORE ";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = "_RESULT INTO '\" + ";
  protected final String TEXT_129 = NL + "\t\t                + \"' using \" + ";
  protected final String TEXT_130 = " + \";\");" + NL + "\t\t        ";
  protected final String TEXT_131 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_132 = "=new StringBuilder();" + NL + "\t\t\tscript_";
  protected final String TEXT_133 = ".append(\"SET parquet.compression ";
  protected final String TEXT_134 = ";\");" + NL + "\t\t\thelper_";
  protected final String TEXT_135 = ".add(\"script\",script_";
  protected final String TEXT_136 = ".toString());" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "                sb_";
  protected final String TEXT_138 = ".append(\"STORE ";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = "_RESULT INTO '\"" + NL + "                        + \"s3n://\" + ";
  protected final String TEXT_141 = " + \":\" + decryptedS3Password_";
  protected final String TEXT_142 = " + \"@\" + ";
  protected final String TEXT_143 = NL + "                        + \"' using parquet.pig.ParquetStorer;\");";
  protected final String TEXT_144 = NL + "                sb_";
  protected final String TEXT_145 = ".append(\"STORE ";
  protected final String TEXT_146 = "_";
  protected final String TEXT_147 = "_RESULT INTO '\" + ";
  protected final String TEXT_148 = NL + "                        + \"' using parquet.pig.ParquetStorer;\");";
  protected final String TEXT_149 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_150 = "=new StringBuilder();" + NL + "\t\t\tscript_";
  protected final String TEXT_151 = ".append(\"SET hbase.zookeeper.quorum \"+";
  protected final String TEXT_152 = "+\";\");" + NL + "\t\t\tscript_";
  protected final String TEXT_153 = ".append(\"SET hbase.zookeeper.property.clientPort \"+";
  protected final String TEXT_154 = "+\";\");";
  protected final String TEXT_155 = NL + "\t\t\tscript_";
  protected final String TEXT_156 = ".append(\"SET zookeeper.znode.parent \"+";
  protected final String TEXT_157 = "+\";\");";
  protected final String TEXT_158 = NL + "\t\t\thelper_";
  protected final String TEXT_159 = ".add(\"script\",script_";
  protected final String TEXT_160 = ".toString());";
  protected final String TEXT_161 = NL + "\t\t\t\tsb_";
  protected final String TEXT_162 = ".append(\"STORE ";
  protected final String TEXT_163 = "_";
  protected final String TEXT_164 = "_RESULT INTO \");";
  protected final String TEXT_165 = NL + "\t\t\t\tsb_";
  protected final String TEXT_166 = ".append(\"";
  protected final String TEXT_167 = "_";
  protected final String TEXT_168 = "_TMP_RESULT = FOREACH ";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = "_RESULT GENERATE \");";
  protected final String TEXT_171 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_172 = ".append(\"$";
  protected final String TEXT_173 = " as column";
  protected final String TEXT_174 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_176 = ".append(\",\");";
  protected final String TEXT_177 = NL + "\t\t\t\tsb_";
  protected final String TEXT_178 = ".append(\";\");" + NL + "\t\t\t\tsb_";
  protected final String TEXT_179 = ".append(\"STORE ";
  protected final String TEXT_180 = "_";
  protected final String TEXT_181 = "_TMP_RESULT INTO \"); ";
  protected final String TEXT_182 = NL + "\t\t\tsb_";
  protected final String TEXT_183 = ".append(\"'\").append(";
  protected final String TEXT_184 = ").append(\"' using org.apache.pig.backend.hadoop.hbase.HBaseStorage('\");;";
  protected final String TEXT_185 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_186 = ".append(";
  protected final String TEXT_187 = ");";
  protected final String TEXT_188 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_189 = ".append(\" \");";
  protected final String TEXT_190 = NL + "\t\t\tsb_";
  protected final String TEXT_191 = ".append(\"'\");";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_193 = ".append(\",'\");";
  protected final String TEXT_194 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_195 = ".append(\"-";
  protected final String TEXT_196 = " \").append(";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_199 = ".append(\" \");";
  protected final String TEXT_200 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_201 = ".append(\"'\");";
  protected final String TEXT_202 = NL + "\t\t\tsb_";
  protected final String TEXT_203 = ".append(\");\");";
  protected final String TEXT_204 = NL + "                sb_";
  protected final String TEXT_205 = ".append(\"STORE ";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = "_RESULT INTO '\"" + NL + "                        + \"s3n://\" + ";
  protected final String TEXT_208 = " + \":\" + decryptedS3Password_";
  protected final String TEXT_209 = " + \"@\" + ";
  protected final String TEXT_210 = NL + "                        + \"' using ";
  protected final String TEXT_211 = "(";
  protected final String TEXT_212 = ");\");";
  protected final String TEXT_213 = NL + "                sb_";
  protected final String TEXT_214 = ".append(\"STORE ";
  protected final String TEXT_215 = "_";
  protected final String TEXT_216 = "_RESULT INTO '\" + ";
  protected final String TEXT_217 = NL + "                        + \"' using ";
  protected final String TEXT_218 = "(";
  protected final String TEXT_219 = ");\");";
  protected final String TEXT_220 = NL + NL + "\thelper_";
  protected final String TEXT_221 = ".add(\"query\",sb_";
  protected final String TEXT_222 = ".toString());" + NL + "\t";
  protected final String TEXT_223 = NL + "\t";
  protected final String TEXT_224 = NL + "\tjava.util.List<String[]> pigLatins_";
  protected final String TEXT_225 = " = helper_";
  protected final String TEXT_226 = ".getPigLatins();";
  protected final String TEXT_227 = NL + "\t\tfor(String[] pigLatin_";
  protected final String TEXT_228 = " : pigLatins_";
  protected final String TEXT_229 = ") {" + NL + "\t\t\tString type_";
  protected final String TEXT_230 = " = pigLatin_";
  protected final String TEXT_231 = "[0];" + NL + "\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_233 = " - register \" + type_";
  protected final String TEXT_234 = " + \" : \" + pigLatin_";
  protected final String TEXT_235 = "[1]);" + NL + "\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\tif(\"query\".equals(type_";
  protected final String TEXT_237 = ")) {";
  protected final String TEXT_238 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_239 = ".write(pigLatin_";
  protected final String TEXT_240 = "[1]);";
  protected final String TEXT_241 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_242 = ".registerQuery(pigLatin_";
  protected final String TEXT_243 = "[1]);";
  protected final String TEXT_244 = NL + "\t\t\t} else if(\"jar\".equals(type_";
  protected final String TEXT_245 = ")) {";
  protected final String TEXT_246 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_247 = ".write(\"REGISTER \" + wasbPath_";
  protected final String TEXT_248 = " + new java.io.File(pigLatin_";
  protected final String TEXT_249 = "[1]).getName() + \";\");" + NL + "\t\t\t\t\tlibjars_";
  protected final String TEXT_250 = ".append(pigLatin_";
  protected final String TEXT_251 = "[1] + \",\");";
  protected final String TEXT_252 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_253 = ".registerJar(pigLatin_";
  protected final String TEXT_254 = "[1]);";
  protected final String TEXT_255 = NL + "\t\t\t} else if(\"script\".equals(type_";
  protected final String TEXT_256 = ")) {";
  protected final String TEXT_257 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_258 = ".write(pigLatin_";
  protected final String TEXT_259 = "[1]);";
  protected final String TEXT_260 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_261 = ".registerScript(new java.io.ByteArrayInputStream(pigLatin_";
  protected final String TEXT_262 = "[1].getBytes()));";
  protected final String TEXT_263 = NL + "\t\t\t} else if(\"function\".equals(type_";
  protected final String TEXT_264 = ")) {";
  protected final String TEXT_265 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_266 = ".write(\"DEFINE \" + pigLatin_";
  protected final String TEXT_267 = "[1] + \" \" + pigLatin_";
  protected final String TEXT_268 = "[2] + \";\");";
  protected final String TEXT_269 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_270 = ".registerFunction(pigLatin_";
  protected final String TEXT_271 = "[1], new org.apache.pig.FuncSpec(pigLatin_";
  protected final String TEXT_272 = "[2]));";
  protected final String TEXT_273 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_274 = NL + "    \tpigScript_";
  protected final String TEXT_275 = ".addAll(pigLatins_";
  protected final String TEXT_276 = ");";
  protected final String TEXT_277 = NL + "\tpigLatins_";
  protected final String TEXT_278 = ".clear();" + NL + "\t";
  protected final String TEXT_279 = NL + "\tpigServer_";
  protected final String TEXT_280 = ".executeBatch();" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_281 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_282 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_283 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}" + NL + "" + NL + "\tString originalHadoopUsername_";
  protected final String TEXT_284 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_285 = "\");" + NL + "    if(originalHadoopUsername_";
  protected final String TEXT_286 = "!=null) {" + NL + "    \tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_287 = ");" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_288 = "\", null);" + NL + "    } else {" + NL + "    \tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "    }";
  protected final String TEXT_289 = NL + NL;
  protected final String TEXT_290 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String previous_node="";
	String start_node="";
	boolean isExecutedThroughWebHCat = false;

	String previousOutputConnectionName = "";
	
	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		IConnection connection = node.getIncomingConnections().get(0);
		previous_node = connection.getSource().getUniqueName();
		INode loadNode = node.getDesignSubjobStartNode();
		start_node = loadNode.getUniqueName();
		
		boolean isLocal = "true".equals(ElementParameterParser.getValue(loadNode, "__LOCAL__"));
		isExecutedThroughWebHCat = !isLocal && "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(loadNode, "__DISTRIBUTION__"));
		
		previousOutputConnectionName = connection.getName();
	}
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	
	String resultFile = ElementParameterParser.getValue(node, "__OUTPUT_FILENAME__");
	boolean isS3Location = "true".equals(ElementParameterParser.getValue(node, "__S3_LOCATION__"));
    String s3bucket = ElementParameterParser.getValue(node, "__S3_BUCKET__");
    String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME__");
   	String function = ElementParameterParser.getValue(node, "__STORE__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR__");
	boolean rmResultDir = "true".equals(ElementParameterParser.getValue(node, "__RM_OUTPUT__"));
	
	String database = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String table = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String partitionFilter = ElementParameterParser.getValue(node, "__PARTITION_KEYVALUE__");
	
	String thriftServer = ElementParameterParser.getValue(node, "__THRIFT_SERVER__");
	
	boolean defineJarsToRegister = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__"));
	List<Map<String, String>> registerJarForHCatalog = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	
	List<Map<String, String>> registerJar = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__DRIVER_JAR__");
	
	boolean generateRegisterJarCodeForHCatalog = ("HCatStorer".equals(function) && !defineJarsToRegister);
	boolean generateRegisterJarCode = registerJar.size() > 0;
	
	java.util.List<String> priorPig012HcatVersionList = java.util.Arrays.<String>asList("HDP_1_2","HDP_1_3","MAPR310");
	String hcatPackage = (priorPig012HcatVersionList.contains(ElementParameterParser.getValue(node, "__HBASE_VERSION__")) && !isCustom) ? "org.apache.hcatalog.pig" : "org.apache.hive.hcatalog.pig";
	
	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	
	boolean generateRegisterJarCodeForHBase = "HBaseStorage".equals(function);
	
	boolean generateRegisterJarCodeForSequenceFile = "SequenceFileStorage".equals(function);
	
	boolean generateRegisterJarCodeForRCFile = "RCFilePigStorage".equals(function);
	
	boolean generateRegisterJarCodeForAvroFile = "AvroStorage".equals(function);
	
	boolean generateRegisterJarCodeForParquetFile = "ParquetStorer".equals(function);
	
	boolean generateRegisterJarCodeForAll = generateRegisterJarCodeForHCatalog || generateRegisterJarCode || generateRegisterJarCodeForHBase || generateRegisterJarCodeForSequenceFile || generateRegisterJarCodeForRCFile || generateRegisterJarCodeForAvroFile || generateRegisterJarCodeForParquetFile;
	
	if(generateRegisterJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();
		
		if(generateRegisterJarCode) {
			for(Map<String, String> jar : registerJar){
				jarsToRegister.add(jar.get("JAR_NAME"));
			}
		}
		
		if(generateRegisterJarCodeForHCatalog) {
			jarsToRegister.add("hcatalog");
			
			jarsToRegister.add("hcatalog-core");
			
			jarsToRegister.add("hive-hcatalog-core");
			
			jarsToRegister.add("hive-exec");
			jarsToRegister.add("hive-metastore");
			jarsToRegister.add("libfb303");
		}
		
		if(generateRegisterJarCodeForHBase) {
			jarsToRegister.add("protobuf-java");
			jarsToRegister.add("hbase");
			jarsToRegister.add("hbase-client");
			jarsToRegister.add("hbase-common");
			jarsToRegister.add("hbase-protocol");
			jarsToRegister.add("hbase-server");
			jarsToRegister.add("zookeeper");
			jarsToRegister.add("guava");
			jarsToRegister.add("htrace-core");
		}
		
		if(generateRegisterJarCodeForSequenceFile) {
			jarsToRegister.add("elephant-bird-core");
			jarsToRegister.add("elephant-bird-hadoop-compat");
			jarsToRegister.add("elephant-bird-pig");
			jarsToRegister.add("pigutil");
		}
		
		if(generateRegisterJarCodeForRCFile) {
			jarsToRegister.add("elephant-bird-core");
			jarsToRegister.add("elephant-bird-hadoop-compat");
			jarsToRegister.add("elephant-bird-rcfile");
			jarsToRegister.add("hive-serde");
			jarsToRegister.add("hive-common");
			jarsToRegister.add("hive-exec");
		}
		
		if(generateRegisterJarCodeForAvroFile) {
			jarsToRegister.add("piggybank");
			jarsToRegister.add("avro");
			jarsToRegister.add("json_simple");
		}
		
		if(generateRegisterJarCodeForParquetFile) {
			jarsToRegister.add("parquet-pig-bundle");
			jarsToRegister.add("snappy-java");
		}
		
		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
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
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_32);
    	
    if (isS3Location) {
        String passwordFieldName = "__S3_PASSWORD__";
        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_35);
    
        } else {
            
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_38);
    
        }
    }
    if(generateRegisterJarCodeForAll) {
        
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
	}	
	
	if(rmResultDir && !("HCatStorer".equals(function)) && !("HBaseStorage".equals(function))){
		if (isS3Location) {
		    

    stringBuffer.append(TEXT_48);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_56);
    
		} else if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_61);
    
		} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
		}
	} 

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    	
	if(generateRegisterJarCodeForAll) {
		for(int i=0; i<jarsToRegister.size(); i++) {
			String jarToRegister = jarsToRegister.get(i);
			for(int j=0; j<jars.size(); j++) {
				if(jars.get(j).contains(jarToRegister)) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_77);
    

				}
			}
		}
	}

	if("HCatStorer".equals(function)) {
		if(!generateRegisterJarCodeForHCatalog) {
			if(defineJarsToRegister && registerJarForHCatalog.size() > 0){
				for(Map<String, String> item : registerJarForHCatalog){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(item.get("JAR_PATH") );
    stringBuffer.append(TEXT_80);
     
				} 
			}
		}

    stringBuffer.append(TEXT_81);
    stringBuffer.append(thriftServer);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(hcatPackage);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(partitionFilter);
    stringBuffer.append(TEXT_90);
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if(metadatas != null && metadatas.size() > 0) {
			metadata = metadatas.get(0);
		}
		if(metadata!=null) {
			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
				for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, metadata.getListColumns().get(i).getLabel()));
    stringBuffer.append(TEXT_96);
    

				}

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
			}
		}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
	} else if("SequenceFileStorage".equals(function)) {
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if(metadatas != null && metadatas.size() > 0) {
			metadata = metadatas.get(0);
		}
		
		String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
		String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");
		
		String talendKeyClass = "";
		String talendValueClass = "";
		
		if(metadata!=null) {
			List<IMetadataColumn> listColumns = metadata.getListColumns();
			
			for (IMetadataColumn column : listColumns) {
				if (column.getLabel().equals(keyColumn)) {
					talendKeyClass = column.getTalendType();
				}
				if (column.getLabel().equals(valueColumn)) {
					talendValueClass = column.getTalendType();
				}
			}
		}
		
		String keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		if (talendKeyClass.equals("id_Boolean")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		if (talendKeyClass.equals("id_Byte")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
		if (talendKeyClass.equals("id_byte[]")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		if (talendKeyClass.equals("id_Double")) keyConverterClass="com.talend.pig.util.DoubleWritableConverter";
		if (talendKeyClass.equals("id_Float")) keyConverterClass="com.talend.pig.util.FloatWritableConverter";
		if (talendKeyClass.equals("id_Integer")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
		if (talendKeyClass.equals("id_Long")) keyConverterClass="com.twitter.elephantbird.pig.util.LongWritableConverter";
		if (talendKeyClass.equals("id_Short")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
		if (talendKeyClass.equals("id_String")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		
		String valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		if (talendValueClass.equals("id_Boolean")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		if (talendValueClass.equals("id_Byte")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
		if (talendValueClass.equals("id_byte[]")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
		if (talendValueClass.equals("id_Double")) valueConverterClass="com.talend.pig.util.DoubleWritableConverter";
		if (talendValueClass.equals("id_Float")) valueConverterClass="com.talend.pig.util.FloatWritableConverter";
		if (talendValueClass.equals("id_Integer")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
		if (talendValueClass.equals("id_Long")) valueConverterClass="com.twitter.elephantbird.pig.util.LongWritableConverter";
		if (talendValueClass.equals("id_Short")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
		if (talendValueClass.equals("id_String")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";

		if (isS3Location) {
            
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(keyConverterClass);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(valueConverterClass);
    stringBuffer.append(TEXT_109);
    
        } else {
            
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(keyConverterClass);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(valueConverterClass);
    stringBuffer.append(TEXT_116);
    
        }
	} else {
		if("CustomStorer".equals(function)) {
		    String customStorer = ElementParameterParser.getValue(node, "__CUSTOM_STORER__");
		    if (isS3Location) {
		        
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(customStorer);
    stringBuffer.append(TEXT_124);
    
		    } else {
		        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(customStorer);
    stringBuffer.append(TEXT_130);
    
		    }
		} else if("ParquetStorer".equals(function)) {
			String parquetCompression = ElementParameterParser.getValue(node, "__PARQUET_COMPRESSION__");

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(parquetCompression);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
			if (isS3Location) {
                
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_143);
    
            } else {
                
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_148);
    
            }
		}else if("HBaseStorage".equals(function)) {
			String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
			String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
			
			boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
			String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");			

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_154);
    
			if(setZNodeParent) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_157);
    
			}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
			
			String hbasetable = ElementParameterParser.getValue(node, "__HBASE_TABLE__");
			String rowKeyColumn = ElementParameterParser.getValue(node, "__ROWKEY_COLUMN__");
			boolean storeRowKeyToColumn = "true".equals(ElementParameterParser.getValue(node, "__CONTAIN_ROW_KEY_COLUMN_IN_HBASE_COLUMN__"));
			
			List<Integer> columnOrders = new ArrayList<Integer>();
			int rowKeyIndex = 0;
			
			List<IMetadataTable> metadatas = node.getMetadataList();
    		IMetadataTable metadata = null;
    		if(metadatas != null && metadatas.size() > 0) {
    			metadata = metadatas.get(0);
    		}
    		if(metadata!=null) {
    			if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {
    				for(int i=0; i<metadata.getListColumns().size(); i++) {
    					String columnName = metadata.getListColumns().get(i).getLabel();
    					if(columnName!=null && columnName.equals(rowKeyColumn)) {
    						rowKeyIndex = i;
    						columnOrders.add(0,i);
    						if(storeRowKeyToColumn) {
    							columnOrders.add(i);
    						}
    					} else {
    						columnOrders.add(i);
    					}
    					
    				}
    			}
    		}
    		
    		if((rowKeyIndex == 0) && !storeRowKeyToColumn) {//the default action

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_164);
    
    		} else {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_170);
    
				for(int i=0;i<columnOrders.size();i++) {
					Integer index = columnOrders.get(i);

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    
					if(i<columnOrders.size()-1) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					}
				}

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_181);
    
    		}

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(hbasetable);
    stringBuffer.append(TEXT_184);
    
			List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
			if(metadata!=null && mapping!=null) {
				for(int i=0;i<mapping.size();i++){
    				Map<String, String> map = mapping.get(i);
        			String schema_column = map.get("SCHEMA_COLUMN");
        			String family_column= map.get("FAMILY_COLUMN");
        			if(!storeRowKeyToColumn && (schema_column!=null) && (schema_column.equals(rowKeyColumn))) {
        				continue;
        			}

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_187);
    
					if(i < mapping.size()-1) {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
					}
    			}
			}

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
			List<Map<String, String>> hbasestorageParams = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__HBASESTORAGE_PARAMETER__");
			if(hbasestorageParams!=null) {
				for(int i=0;i<hbasestorageParams.size();i++) {
					if(i == 0) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    					
					}
					Map<String, String> param = hbasestorageParams.get(i);
					String name = param.get("PARAM_NAME");
					String value = param.get("PARAM_VALUE");

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_197);
    							
					if(i < hbasestorageParams.size()-1) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    							
					} else {

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    					
					}
				}
			}

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
		} else {
    		if("RCFilePigStorage".equals(function)) {
    			function = "com.twitter.elephantbird.pig.store.RCFilePigStorage";
    		}
    		
			if("AvroStorage".equals(function)) {
				function = "org.apache.pig.piggybank.storage.avro.AvroStorage";
			}
			
			if (isS3Location) {
                
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_211);
    stringBuffer.append("PigStorage".equals(function)?"'\"+"+fieldSeparator+"+\"'":"");
    stringBuffer.append(TEXT_212);
    
            } else {
                
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(resultFile);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_218);
    stringBuffer.append("PigStorage".equals(function)?"'\"+"+fieldSeparator+"+\"'":"");
    stringBuffer.append(TEXT_219);
    
            }
		}
	}

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
	boolean inMain = true;

    stringBuffer.append(TEXT_223);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
	if(inMain) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    					
				} else {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
				}

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    					
				} else {

    stringBuffer.append(TEXT_252);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
				}

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    					
				} else {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    
				}

    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    					
				} else {

    stringBuffer.append(TEXT_269);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
				}

    stringBuffer.append(TEXT_273);
    
	} else {

    stringBuffer.append(TEXT_274);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    
	}

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
	if(NodeUtil.isSubTreeEnd(node) && !isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_279);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_288);
    
	}

    stringBuffer.append(TEXT_289);
    stringBuffer.append(TEXT_290);
    return stringBuffer.toString();
  }
}
