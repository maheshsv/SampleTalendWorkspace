package org.talend.designer.codegen.translators.bigdata.googlebigquery;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;

public class TBigQueryBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TBigQueryBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBigQueryBulkExecBeginJava result = new TBigQueryBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tfinal String CLIENT_ID_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t";
  protected final String TEXT_5 = NL + "    ";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + "\t" + NL + "\t" + NL + "\tfinal String CLIENT_SECRET_";
  protected final String TEXT_13 = " = \"{\\\"web\\\": {\\\"client_id\\\": \\\"\"+";
  protected final String TEXT_14 = "+\"\\\",\\\"client_secret\\\": \\\"\" +decryptedPassword_";
  protected final String TEXT_15 = "+ \"\\\",\\\"auth_uri\\\": \\\"https://accounts.google.com/o/oauth2/auth\\\",\\\"token_uri\\\": \\\"https://accounts.google.com/o/oauth2/token\\\"}}\";" + NL + "\tfinal String PROJECT_ID_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "" + NL + "\t// Static variables for API scope, callback URI, and HTTP/JSON functions" + NL + "\tfinal List<String> SCOPES_";
  protected final String TEXT_18 = " = java.util.Arrays.asList(\"https://www.googleapis.com/auth/bigquery\");" + NL + "\tfinal String REDIRECT_URI_";
  protected final String TEXT_19 = " = \"urn:ietf:wg:oauth:2.0:oob\";" + NL + "\tfinal com.google.api.client.http.HttpTransport TRANSPORT_";
  protected final String TEXT_20 = " = new com.google.api.client.http.javanet.NetHttpTransport();" + NL + "\tfinal com.google.api.client.json.JsonFactory JSON_FACTORY_";
  protected final String TEXT_21 = " = new com.google.api.client.json.jackson2.JacksonFactory();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets clientSecrets_";
  protected final String TEXT_22 = " = com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.load(" + NL + "\t\t\t\t\tnew com.google.api.client.json.jackson2.JacksonFactory(), new java.io.InputStreamReader(new java.io.ByteArrayInputStream(" + NL + "\t\t\t\t\t\t\tCLIENT_SECRET_";
  protected final String TEXT_23 = ".getBytes())));" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow flow_";
  protected final String TEXT_24 = " = null;" + NL + "\tcom.google.api.services.bigquery.Bigquery bigqueryclient_";
  protected final String TEXT_25 = " = null;" + NL + "\tlong nb_line_";
  protected final String TEXT_26 = " = 0;" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\tlog.info(\"";
  protected final String TEXT_28 = " - Service Account Scopes [https://www.googleapis.com/auth/bigquery]\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_29 = " - Redirect uris [urn:ietf:wg:oauth:2.0:oob]\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_30 = " - Attempt to load existing refresh token\");" + NL + "\t";
  protected final String TEXT_31 = NL + "\t// Attempt to load existing refresh token" + NL + "\tString tokenFile_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_34 = " = new java.util.Properties();" + NL + "\ttry {" + NL + "\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_35 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_36 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_37 = ".load(inputStream_";
  protected final String TEXT_38 = ");" + NL + "\t\tinputStream_";
  protected final String TEXT_39 = ".close();" + NL + "\t} catch (java.io.FileNotFoundException e_";
  protected final String TEXT_40 = ") {" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_42 = " - \"+e_";
  protected final String TEXT_43 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t} catch (java.io.IOException ee_";
  protected final String TEXT_45 = ") {" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_47 = " - \"+ee_";
  protected final String TEXT_48 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t}" + NL + "\tString storedRefreshToken_";
  protected final String TEXT_50 = " = (String) properties_";
  protected final String TEXT_51 = ".get(\"refreshtoken\");" + NL + "" + NL + "\t// Check to see if the an existing refresh token was loaded." + NL + "\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t// access token." + NL + "\tif (storedRefreshToken_";
  protected final String TEXT_52 = " != null) {" + NL + "\t\t// Request a new Access token using the refresh token." + NL + "\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential_";
  protected final String TEXT_53 = " = new com.google.api.client.googleapis.auth.oauth2. GoogleCredential.Builder().setTransport(TRANSPORT_";
  protected final String TEXT_54 = ")" + NL + "\t\t\t\t.setJsonFactory(JSON_FACTORY_";
  protected final String TEXT_55 = ").setClientSecrets(clientSecrets_";
  protected final String TEXT_56 = ")" + NL + "\t\t\t\t.build().setFromTokenResponse(new com.google.api.client.auth.oauth2.TokenResponse().setRefreshToken(storedRefreshToken_";
  protected final String TEXT_57 = "));" + NL + "\t\t" + NL + "\t\tcredential_";
  protected final String TEXT_58 = ".refreshToken();" + NL + "\t\t";
  protected final String TEXT_59 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_60 = " - An existing refresh token was loaded.\");" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tbigqueryclient_";
  protected final String TEXT_62 = " = new com.google.api.services.bigquery.Bigquery.Builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson2.JacksonFactory(),credential_";
  protected final String TEXT_63 = ").setApplicationName(\"Talend\").build();" + NL + "\t} else {" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_65 = " - The refresh token does not exist.\");" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\t\tString authorizeUrl_";
  protected final String TEXT_67 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl(" + NL + "\t\t\t\t\tclientSecrets_";
  protected final String TEXT_68 = ", REDIRECT_URI_";
  protected final String TEXT_69 = ", SCOPES_";
  protected final String TEXT_70 = ").setState(\"\").build();" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_72 = " - Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_73 = ");" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\tSystem.out" + NL + "\t\t\t\t\t.println(\"Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_75 = ");" + NL + "\t\t\tthrow new java.lang.Exception(\"Authorization Code error\");" + NL + "\t\t";
  protected final String TEXT_76 = NL + "\t\t\tString authorizationCode_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_80 = " - Exchange the auth code for an access token and refesh token.\");" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t// Exchange the auth code for an access token and refesh token" + NL + "\t\t\tif (flow_";
  protected final String TEXT_82 = " == null) {" + NL + "\t\t\t\tflow_";
  protected final String TEXT_83 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow.Builder(new com.google.api.client.http.javanet.NetHttpTransport()," + NL + "\t\t\t\t\t\tnew com.google.api.client.json.jackson2.JacksonFactory(), clientSecrets_";
  protected final String TEXT_84 = ", SCOPES_";
  protected final String TEXT_85 = ")" + NL + "\t\t\t\t\t\t.setAccessType(\"offline\").setApprovalPrompt(\"force\")" + NL + "\t\t\t\t\t\t.build();" + NL + "\t\t\t}" + NL + "\t\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse response_";
  protected final String TEXT_86 = " = flow_";
  protected final String TEXT_87 = ".newTokenRequest(authorizationCode_";
  protected final String TEXT_88 = ").setRedirectUri(REDIRECT_URI_";
  protected final String TEXT_89 = ").execute();" + NL + "\t\t\tcom.google.api.client.auth.oauth2.Credential credential_";
  protected final String TEXT_90 = " = flow_";
  protected final String TEXT_91 = ".createAndStoreCredential(response_";
  protected final String TEXT_92 = ", null);" + NL + "\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_94 = " - Store the refresh token for future use.\");" + NL + "\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t// Store the refresh token for future use." + NL + "\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_96 = " = new java.util.Properties();" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_97 = ".setProperty(\"refreshtoken\", credential_";
  protected final String TEXT_98 = ".getRefreshToken());" + NL + "\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_99 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_100 = ");" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_101 = ".store(outputStream_";
  protected final String TEXT_102 = ",null);" + NL + "\t\t\tif (outputStream_";
  protected final String TEXT_103 = " != null) {" + NL + "\t\t\t    outputStream_";
  protected final String TEXT_104 = ".close();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tbigqueryclient_";
  protected final String TEXT_105 = " = new com.google.api.services.bigquery.Bigquery.Builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson2.JacksonFactory(),credential_";
  protected final String TEXT_106 = ").build();" + NL + "\t\t";
  protected final String TEXT_107 = NL + "\t}" + NL + "" + NL + "" + NL + "/* -------------------------------------- */" + NL + "" + NL + "\t" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = NL + "        ";
  protected final String TEXT_110 = " " + NL + "        \tfinal String decryptedPwd_";
  protected final String TEXT_111 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "        \tfinal String decryptedPwd_";
  protected final String TEXT_114 = " = ";
  protected final String TEXT_115 = "; ";
  protected final String TEXT_116 = NL + NL + NL + "\t\torg.jets3t.service.security.GSCredentials gsCredentials = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_117 = ", decryptedPwd_";
  protected final String TEXT_118 = ");" + NL + "\t\t" + NL + "\t\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService gsService = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(gsCredentials);" + NL + "\t\t//org.jets3t.service.model.GSBucket[] myBuckets = gsService.listAllBuckets();" + NL + "\t\t//System.out.println(\"How many buckets to I have in GS? \" + myBuckets.length);" + NL + "" + NL + "\t\tjava.io.File fileData = new java.io.File(";
  protected final String TEXT_119 = ");" + NL + "\t\torg.jets3t.service.model.GSObject fileObject = new org.jets3t.service.model.GSObject(fileData);" + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_121 = " - Upload \"+";
  protected final String TEXT_122 = " + \" to Google Service Bucket: \"+";
  protected final String TEXT_123 = ");" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\tgsService.putObject(";
  protected final String TEXT_125 = ", fileObject);" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_127 = " - Upload Done.\");" + NL + "\t\t";
  protected final String TEXT_128 = NL + NL + "/* ------------------------------------------- */" + NL + "" + NL + "\t";
  protected final String TEXT_129 = NL + "\t\tlog.info(\"";
  protected final String TEXT_130 = " - Starting build a job.\");" + NL + "\t";
  protected final String TEXT_131 = NL + "\tcom.google.api.services.bigquery.model.Job job_";
  protected final String TEXT_132 = " = new com.google.api.services.bigquery.model.Job();" + NL + "\tjob_";
  protected final String TEXT_133 = ".setJobReference(new com.google.api.services.bigquery.model.JobReference().setProjectId(PROJECT_ID_";
  protected final String TEXT_134 = "));" + NL + "" + NL + "\tcom.google.api.services.bigquery.model.JobConfiguration config_";
  protected final String TEXT_135 = " = new com.google.api.services.bigquery.model.JobConfiguration();" + NL + "\tcom.google.api.services.bigquery.model.JobConfigurationLoad queryLoad_";
  protected final String TEXT_136 = " = new com.google.api.services.bigquery.model.JobConfigurationLoad();" + NL + "\tcom.google.api.services.bigquery.model.TableSchema schema_";
  protected final String TEXT_137 = " = new com.google.api.services.bigquery.model.TableSchema();" + NL + "" + NL + "\t";
  protected final String TEXT_138 = NL + "\t\tlog.info(\"";
  protected final String TEXT_139 = " - Table field schema:\");" + NL + "\t";
  protected final String TEXT_140 = NL + "\tjava.util.List<com.google.api.services.bigquery.model.TableFieldSchema> fields_";
  protected final String TEXT_141 = " = new java.util.ArrayList<com.google.api.services.bigquery.model.TableFieldSchema>();" + NL + "\t";
  protected final String TEXT_142 = NL + "\t\t\t\tcom.google.api.services.bigquery.model.TableFieldSchema ";
  protected final String TEXT_143 = " = new com.google.api.services.bigquery.model.TableFieldSchema();" + NL + "\t\t\t\t";
  protected final String TEXT_144 = ".setName(\"";
  protected final String TEXT_145 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_146 = ".setType(\"";
  protected final String TEXT_147 = "\");" + NL + "\t\t\t\tfields_";
  protected final String TEXT_148 = ".add(";
  protected final String TEXT_149 = ");\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_151 = " - Field index[";
  protected final String TEXT_152 = "] {\\\"name\\\":\\\"";
  protected final String TEXT_153 = "\\\",\\\"type\\\":\\\"";
  protected final String TEXT_154 = "\\\"}\");" + NL + "\t\t\t\t";
  protected final String TEXT_155 = NL + "\t" + NL + "" + NL + "\tschema_";
  protected final String TEXT_156 = ".setFields(fields_";
  protected final String TEXT_157 = ");" + NL + "" + NL + "\tqueryLoad_";
  protected final String TEXT_158 = ".setSchema(schema_";
  protected final String TEXT_159 = ");" + NL + "\t";
  protected final String TEXT_160 = NL + "\t\tqueryLoad_";
  protected final String TEXT_161 = ".setCreateDisposition(\"CREATE_IF_NEEDED\");" + NL + "\t";
  protected final String TEXT_162 = NL + "\t\tqueryLoad_";
  protected final String TEXT_163 = ".setCreateDisposition(\"CREATE_NEVER\");" + NL + "\t";
  protected final String TEXT_164 = NL + "\t\tqueryLoad_";
  protected final String TEXT_165 = ".setFieldDelimiter(";
  protected final String TEXT_166 = ");" + NL + "\t";
  protected final String TEXT_167 = NL + "\tqueryLoad_";
  protected final String TEXT_168 = ".setAllowQuotedNewlines(true);" + NL + "" + NL + "\tqueryLoad_";
  protected final String TEXT_169 = ".setWriteDisposition(\"WRITE_";
  protected final String TEXT_170 = "\");" + NL + "\tcom.google.api.services.bigquery.model.TableReference destinationTable_";
  protected final String TEXT_171 = " = new com.google.api.services.bigquery.model.TableReference();" + NL + "\tdestinationTable_";
  protected final String TEXT_172 = ".setProjectId(PROJECT_ID_";
  protected final String TEXT_173 = ");" + NL + "\tdestinationTable_";
  protected final String TEXT_174 = ".setDatasetId(";
  protected final String TEXT_175 = ");" + NL + "\tdestinationTable_";
  protected final String TEXT_176 = ".setTableId(";
  protected final String TEXT_177 = ");" + NL + "" + NL + "\tqueryLoad_";
  protected final String TEXT_178 = ".setDestinationTable(destinationTable_";
  protected final String TEXT_179 = ");" + NL + "\tqueryLoad_";
  protected final String TEXT_180 = ".setSourceUris(java.util.Arrays.asList(";
  protected final String TEXT_181 = "));" + NL + "\tqueryLoad_";
  protected final String TEXT_182 = ".setSkipLeadingRows(";
  protected final String TEXT_183 = ");" + NL + "" + NL + "\tconfig_";
  protected final String TEXT_184 = ".setLoad(queryLoad_";
  protected final String TEXT_185 = ");" + NL + "\t" + NL + "\tjob_";
  protected final String TEXT_186 = ".setConfiguration(config_";
  protected final String TEXT_187 = ");" + NL + "" + NL + "\tcom.google.api.services.bigquery.Bigquery.Jobs.Insert insertReq_";
  protected final String TEXT_188 = " = bigqueryclient_";
  protected final String TEXT_189 = ".jobs().insert(\"\", job_";
  protected final String TEXT_190 = ");" + NL + "\tinsertReq_";
  protected final String TEXT_191 = ".setProjectId(PROJECT_ID_";
  protected final String TEXT_192 = ");" + NL + "\t";
  protected final String TEXT_193 = NL + "\t\tlog.info(\"";
  protected final String TEXT_194 = " - Build a job successfully.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_195 = " - Starting load the job.\");" + NL + "\t";
  protected final String TEXT_196 = NL + "\tSystem.out.println(\"Starting load job.\");" + NL + "\tcom.google.api.services.bigquery.model.Job jobExec_";
  protected final String TEXT_197 = " = null;" + NL + "\ttry {" + NL + "\t\tjobExec_";
  protected final String TEXT_198 = " = insertReq_";
  protected final String TEXT_199 = ".execute();" + NL + "\t} catch (Exception ee_";
  protected final String TEXT_200 = ") {" + NL + "\t\t";
  protected final String TEXT_201 = NL + "\t\t\tthrow ee_";
  protected final String TEXT_202 = ";" + NL + "\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_204 = " - \"+ ee_";
  protected final String TEXT_205 = ".getMessage() + \"\\n\" + ee_";
  protected final String TEXT_206 = ".getCause());" + NL + "\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\tSystem.err.println(ee_";
  protected final String TEXT_208 = ".getMessage() + \"\\n\" + ee_";
  protected final String TEXT_209 = ".getCause());" + NL + "\t\t";
  protected final String TEXT_210 = NL + "\t}" + NL + "\tif (jobExec_";
  protected final String TEXT_211 = ".getStatus().getState().equals(\"RUNNING\")" + NL + "\t\t\t|| jobExec_";
  protected final String TEXT_212 = ".getStatus().getState().equals(\"PENDING\")) {" + NL + "\t\tcom.google.api.services.bigquery.model.Job pollJob_";
  protected final String TEXT_213 = " = bigqueryclient_";
  protected final String TEXT_214 = ".jobs().get(PROJECT_ID_";
  protected final String TEXT_215 = ",jobExec_";
  protected final String TEXT_216 = ".getJobReference().getJobId()).execute();" + NL + "\t\twhile (pollJob_";
  protected final String TEXT_217 = ".getStatus().getState().equals(\"RUNNING\") || pollJob_";
  protected final String TEXT_218 = ".getStatus().getState().equals(\"PENDING\")) {" + NL + "\t\t\tThread.sleep(1000);" + NL + "\t\t\tpollJob_";
  protected final String TEXT_219 = " = bigqueryclient_";
  protected final String TEXT_220 = ".jobs().get(PROJECT_ID_";
  protected final String TEXT_221 = ",jobExec_";
  protected final String TEXT_222 = ".getJobReference().getJobId()).execute();" + NL + "\t\t\tSystem.out.println(String.format(" + NL + "\t\t\t\t\t\"Waiting on job %s ... Current status: %s\", jobExec_";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\t\t.getJobReference().getJobId(), pollJob_";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t.getStatus().getState()));" + NL + "\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_226 = " - \"+String.format(\"Waiting on job %s ... Current status: %s\", jobExec_";
  protected final String TEXT_227 = ".getJobReference().getJobId(), pollJob_";
  protected final String TEXT_228 = ".getStatus().getState()));" + NL + "\t\t\t";
  protected final String TEXT_229 = NL + "\t\t}" + NL + "" + NL + "\t\tcom.google.api.services.bigquery.model.Job doneJob_";
  protected final String TEXT_230 = " = pollJob_";
  protected final String TEXT_231 = ";" + NL + "\t\tSystem.out.println(\"Done: \" + doneJob_";
  protected final String TEXT_232 = ".toString());" + NL + "\t\tcom.google.api.services.bigquery.model.JobStatistics jobStatistics_";
  protected final String TEXT_233 = "= doneJob_";
  protected final String TEXT_234 = ".getStatistics();" + NL + "\t\tif(jobStatistics_";
  protected final String TEXT_235 = "!=null && jobStatistics_";
  protected final String TEXT_236 = ".getLoad() != null){" + NL + "\t\t\tcom.google.api.services.bigquery.model.JobStatistics3 loadObject_";
  protected final String TEXT_237 = " = jobStatistics_";
  protected final String TEXT_238 = ".getLoad();" + NL + "\t\t\tif(loadObject_";
  protected final String TEXT_239 = "!= null){" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_240 = " = loadObject_";
  protected final String TEXT_241 = ".getOutputRows();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_242 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_243 = " - Load Done: \" + doneJob_";
  protected final String TEXT_244 = ".toString());" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_245 = " - \" + nb_line_";
  protected final String TEXT_246 = " + \" records load successfully.\");" + NL + "\t\t";
  protected final String TEXT_247 = NL + "\t} else {" + NL + "\t\t";
  protected final String TEXT_248 = NL + "\t\t\tthrow new Exception(jobExec_";
  protected final String TEXT_249 = ".toString());" + NL + "\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_251 = " - Error: \" + jobExec_";
  protected final String TEXT_252 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\tSystem.err.println(\"Error: \" + jobExec_";
  protected final String TEXT_254 = ".toString());" + NL + "\t\t";
  protected final String TEXT_255 = NL + "\t}" + NL + "\t";
  protected final String TEXT_256 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

	INode node = (INode)codeGenArgument.getArgument();

	String cid = node.getUniqueName();

	String clientId = ElementParameterParser.getValue(node,"__CLIENT_ID__");
	String clientSecret = ElementParameterParser.getValue(node,"__CLIENT_SECRET__");
	String projectId = ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String authorizationCode = ElementParameterParser.getValue(node,"__AUTHORIZATION_CODE__");

	String actionOnData = ElementParameterParser.getValue(node, "__ACTION_ON_DATA__");
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    String tokenFile = ElementParameterParser.getValue(node,"__TOKEN_NAME__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String passwordFieldName = "";
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clientId );
    stringBuffer.append(TEXT_4);
    
    passwordFieldName = "__CLIENT_SECRET__";
    
    stringBuffer.append(TEXT_5);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(projectId );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
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
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
	}
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
		}
		
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		}
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
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
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
		}
		
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
		}
		if(authorizationCode==null || "".equals(authorizationCode) || "\"\"".equals(authorizationCode)) {
		
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	    	if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
			}
	    	
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		} else {
		
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(authorizationCode);
    stringBuffer.append(TEXT_78);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
			}
			
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
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
			}
			
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
		}
		
    stringBuffer.append(TEXT_107);
    
	boolean bulkFileAlreadyExists = "true".equals(ElementParameterParser.getValue(node, "__BULK_FILE_ALREADY_EXIST__"));
	String accessKey = ElementParameterParser.getValue(node, "__GS_ACCESS_KEY__");
	String secretKey = ElementParameterParser.getValue(node, "__GS_SECRET_KEY__");
	String localFilename = ElementParameterParser.getValue(node, "__GS_LOCAL_FILE__");
	String bucketName = ElementParameterParser.getValue(node, "__BUCKET_NAME__");
	if(!bulkFileAlreadyExists) {
	
    stringBuffer.append(TEXT_108);
    
        passwordFieldName = "__GS_SECRET_KEY__";
        
    stringBuffer.append(TEXT_109);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_112);
    } else {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(localFilename);
    stringBuffer.append(TEXT_119);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(localFilename);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_123);
    
		}
		
    stringBuffer.append(TEXT_124);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_125);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
		}
	}
	
    stringBuffer.append(TEXT_128);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
	}
	
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
	}
	
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null) && (metadatas.size() > 0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {
			List<IMetadataColumn> columns = metadata.getListColumns();
			int nbColumns = columns.size();
			for (int i = 0; i < nbColumns; i++ ) {
				IMetadataColumn column = columns.get(i);
				String columnName = column.getLabel();
				String typeToGenerate = "string";
				if("id_Float".equals(column.getTalendType())) {
					typeToGenerate = "float";
				} else if("id_Integer".equals(column.getTalendType())) {
					typeToGenerate = "integer";
				} else if("id_Boolean".equals(column.getTalendType())) {
					typeToGenerate = "boolean";
				} else if("id_Date".equals(column.getTalendType())) {
					typeToGenerate = "timestamp";
				}
				
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_149);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_154);
    
				}
			}
		}
	}
	
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
	if("true".equals(ElementParameterParser.getValue(node, "__CREATE_TABLE_IF_NOT_EXIST__"))) {
	
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
	} else {
	
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
	}

	if("true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_DELIMITER__"))) {
	
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELD_DELIMITER__"));
    stringBuffer.append(TEXT_166);
    
	}
	
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(actionOnData);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DATASET__"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE__"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GS_FILE__"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GS_FILE_HEADER__"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
	}
	
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
		if(dieOnError) {
		
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
			}
			
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
		}
		
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
			}
			
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
		}
		
    stringBuffer.append(TEXT_247);
    
		if(dieOnError) {
		
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
			}
			
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
		}
		
    stringBuffer.append(TEXT_255);
    stringBuffer.append(TEXT_256);
    return stringBuffer.toString();
  }
}
