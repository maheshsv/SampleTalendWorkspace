package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THDFSRenameMainJava
{
  protected static String nl;
  public static synchronized THDFSRenameMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSRenameMainJava result = new THDFSRenameMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_STATUS\", \"No file renamed.\");\t      \t\t\t\t" + NL + "   \t\tjava.util.Set<String> keySet_";
  protected final String TEXT_4 = " = map_";
  protected final String TEXT_5 = ".keySet();" + NL + "   \t\tString tmp_";
  protected final String TEXT_6 = " = pid + System.currentTimeMillis();" + NL + "      \tfor (String key_";
  protected final String TEXT_7 = " : keySet_";
  protected final String TEXT_8 = "){" + NL + "\t\t\tString fromFileMask_";
  protected final String TEXT_9 = " = (";
  protected final String TEXT_10 = " + \"/\" + key_";
  protected final String TEXT_11 = ").replaceAll(\"\\\\\\\\\",\"/\"); " + NL + "\t\t\torg.apache.hadoop.fs.Path fromPathMask_";
  protected final String TEXT_12 = " = new org.apache.hadoop.fs.Path(fromFileMask_";
  protected final String TEXT_13 = ");" + NL + "\t\t\torg.apache.hadoop.fs.Path fromParent_";
  protected final String TEXT_14 = " = fromPathMask_";
  protected final String TEXT_15 = ".getParent();" + NL + "\t\t\tString mask_";
  protected final String TEXT_16 = " = fromPathMask_";
  protected final String TEXT_17 = ".getName();" + NL + "\t\t\tmask_";
  protected final String TEXT_18 = " = mask_";
  protected final String TEXT_19 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\");\t\t\t" + NL + "\t\t\tjava.util.regex.Pattern pattern_";
  protected final String TEXT_20 = " = java.util.regex.Pattern.compile(mask_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t" + NL + "\t\t\torg.apache.hadoop.fs.FileStatus[] status_";
  protected final String TEXT_22 = " = fs_";
  protected final String TEXT_23 = ".listStatus(fromParent_";
  protected final String TEXT_24 = ");" + NL + "\t\t\tint count_";
  protected final String TEXT_25 = " = 0;" + NL + "\t\t\tString uniqueName_";
  protected final String TEXT_26 = " = null;" + NL + "\t\t\t" + NL + "\t\t\tif(status_";
  protected final String TEXT_27 = "!=null) {" + NL + "\t\t\t\tfor(org.apache.hadoop.fs.FileStatus statu_";
  protected final String TEXT_28 = " : status_";
  protected final String TEXT_29 = ") {" + NL + "\t\t\t\t\tString filename_";
  protected final String TEXT_30 = " =  statu_";
  protected final String TEXT_31 = ".getPath().getName();" + NL + "\t\t\t\t\tif(pattern_";
  protected final String TEXT_32 = ".matcher(filename_";
  protected final String TEXT_33 = ").matches()) {" + NL + "\t\t\t\t\t\tcount_";
  protected final String TEXT_34 = "++;" + NL + "\t\t\t\t\t\tuniqueName_";
  protected final String TEXT_35 = " = filename_";
  protected final String TEXT_36 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(count_";
  protected final String TEXT_37 = "!=1) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_38 = "_CURRENT_STATUS\", \"File rename fail:file does not exist or no unique matching for current filemask\");" + NL + "\t\t\t\tSystem.err.println(\"Info : file does not exist or no unique matching for current filemask\");" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "       \t\t\tlog.error(\"";
  protected final String TEXT_40 = " - file does not exist or no unique matching for current filemask : \" + mask_";
  protected final String TEXT_41 = ");" + NL + "        \t\t";
  protected final String TEXT_42 = NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tString parent_";
  protected final String TEXT_43 = " = fromParent_";
  protected final String TEXT_44 = ".toString();" + NL + "\t\t\tString fromFile_";
  protected final String TEXT_45 = " = parent_";
  protected final String TEXT_46 = " + (parent_";
  protected final String TEXT_47 = ".endsWith(\"/\") ? \"\" : \"/\") + uniqueName_";
  protected final String TEXT_48 = ";" + NL + "    \t\tString toFile_";
  protected final String TEXT_49 = " = (";
  protected final String TEXT_50 = " + \"/\" + map_";
  protected final String TEXT_51 = ".get(key_";
  protected final String TEXT_52 = ")).replaceAll(\"\\\\\\\\\",\"/\");" + NL + "    \t\torg.apache.hadoop.fs.Path toPath_";
  protected final String TEXT_53 = " = new org.apache.hadoop.fs.Path(toFile_";
  protected final String TEXT_54 = ");" + NL + "    \t\ttoFile_";
  protected final String TEXT_55 = " = toPath_";
  protected final String TEXT_56 = ".toString();" + NL + "    \t\tif (!fromFile_";
  protected final String TEXT_57 = ".equals(toFile_";
  protected final String TEXT_58 = ")){" + NL + "    \t\t\torg.apache.hadoop.fs.Path fromPath_";
  protected final String TEXT_59 = " = new org.apache.hadoop.fs.Path(fromFile_";
  protected final String TEXT_60 = ");" + NL + "    \t\t\ttry {" + NL + "\t\t    \t\tif(!fs_";
  protected final String TEXT_61 = ".exists(toPath_";
  protected final String TEXT_62 = ")) {" + NL + "\t\t    \t\t\tboolean success_";
  protected final String TEXT_63 = " = fs_";
  protected final String TEXT_64 = ".rename(fromPath_";
  protected final String TEXT_65 = ",toPath_";
  protected final String TEXT_66 = ");" + NL + "\t\t    \t\t\tif(success_";
  protected final String TEXT_67 = ") {" + NL + "\t\t    \t\t\t\t";
  protected final String TEXT_68 = NL + "                   \t\t\tlog.info(\"";
  protected final String TEXT_69 = " - \" + fromPath_";
  protected final String TEXT_70 = " + \" is renamed as \" + toPath_";
  protected final String TEXT_71 = " + \".\");" + NL + "                    \t\t";
  protected final String TEXT_72 = NL + "\t\t    \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_73 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t\t    \t\t\t\tnb_file_";
  protected final String TEXT_74 = "++;" + NL + "\t\t    \t\t\t} else {" + NL + "\t\t    \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_75 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "\t\t    \t\t\t\tSystem.err.println(\"Info : File rename fail\");" + NL + "            \t\t\t\t";
  protected final String TEXT_76 = NL + "                   \t\t\tlog.error(\"";
  protected final String TEXT_77 = " - fail to rename file from \" + fromPath_";
  protected final String TEXT_78 = " + \" to \" + toPath_";
  protected final String TEXT_79 = ");" + NL + "                    \t\t";
  protected final String TEXT_80 = NL + "\t\t    \t\t\t}" + NL + "\t\t    \t\t}" + NL + "\t\t    \t\t";
  protected final String TEXT_81 = NL + "\t\t    \t\telse {" + NL + "\t\t    \t\t\tString tempFile_";
  protected final String TEXT_82 = " = toFile_";
  protected final String TEXT_83 = " + \".\" + tmp_";
  protected final String TEXT_84 = ";" + NL + "\t\t    \t\t\torg.apache.hadoop.fs.Path tempPath_";
  protected final String TEXT_85 = " = new org.apache.hadoop.fs.Path(tempFile_";
  protected final String TEXT_86 = ");" + NL + "\t\t    \t\t\tboolean success_";
  protected final String TEXT_87 = " = true;" + NL + "\t     \t\t    \tif(fs_";
  protected final String TEXT_88 = ".exists(tempPath_";
  protected final String TEXT_89 = ")){" + NL + "\t     \t\t    \t\tfs_";
  protected final String TEXT_90 = ".delete(tempPath_";
  protected final String TEXT_91 = ");" + NL + "\t     \t\t    \t}" + NL + "\t     \t\t    \t" + NL + "\t\t     \t\t\tsuccess_";
  protected final String TEXT_92 = " = success_";
  protected final String TEXT_93 = " && fs_";
  protected final String TEXT_94 = ".rename(toPath_";
  protected final String TEXT_95 = ", tempPath_";
  protected final String TEXT_96 = ");" + NL + "\t\t     \t\t\tsuccess_";
  protected final String TEXT_97 = " = success_";
  protected final String TEXT_98 = " && fs_";
  protected final String TEXT_99 = ".rename(fromPath_";
  protected final String TEXT_100 = ", toPath_";
  protected final String TEXT_101 = ");" + NL + "\t\t     \t\t\t" + NL + "\t\t     \t\t\tfs_";
  protected final String TEXT_102 = ".delete(tempPath_";
  protected final String TEXT_103 = ");" + NL + "\t\t     \t\t\t" + NL + "\t\t     \t\t\tif(success_";
  protected final String TEXT_104 = ") {" + NL + "\t\t     \t\t\t    ";
  protected final String TEXT_105 = NL + "                   \t\t\tlog.info(\"";
  protected final String TEXT_106 = " - \" + fromPath_";
  protected final String TEXT_107 = " + \" is renamed as \" + toPath_";
  protected final String TEXT_108 = " + \".\");" + NL + "                    \t\t";
  protected final String TEXT_109 = NL + "\t\t    \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_110 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t\t    \t\t\t\tnb_file_";
  protected final String TEXT_111 = "++;" + NL + "\t\t    \t\t\t} else {" + NL + "\t\t    \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_112 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "\t\t    \t\t\t\tSystem.err.println(\"Info : File rename fail\");" + NL + "            \t\t\t\t";
  protected final String TEXT_113 = NL + "                   \t\t\tlog.error(\"";
  protected final String TEXT_114 = " - fail to rename file from \" + fromPath_";
  protected final String TEXT_115 = " + \" to \" + toPath_";
  protected final String TEXT_116 = ");" + NL + "                    \t\t";
  protected final String TEXT_117 = NL + "\t\t    \t\t\t}" + NL + "\t\t    \t\t}" + NL + "\t\t    \t\t";
  protected final String TEXT_118 = NL + "\t    \t\t} catch(java.io.IOException e) {" + NL + "\t    \t\t\tglobalMap.put(\"";
  protected final String TEXT_119 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "            \t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\tthrow(e);" + NL + "\t\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\tSystem.err.print(e.getMessage());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_122 = NL + "           \t\t\tlog.error(\"";
  protected final String TEXT_123 = " - fail to rename file : \" + e.getMessage());" + NL + "            \t\t\t";
  protected final String TEXT_124 = "\t    \t\t" + NL + "\t    \t\t}" + NL + "    \t\t}" + NL + "\t    }";
  protected final String TEXT_125 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean overwrite = ("true").equals(ElementParameterParser.getValue(node, "__OVERWRITE__"));
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    if(overwrite){
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    if(("true").equals(dieOnError)){
    stringBuffer.append(TEXT_120);
    }else{
    stringBuffer.append(TEXT_121);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    }
					}
    stringBuffer.append(TEXT_124);
    stringBuffer.append(TEXT_125);
    return stringBuffer.toString();
  }
}
