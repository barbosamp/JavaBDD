package br.com.application.name.reports.evidence;

import br.com.application.name.reports.ExcelReport;
import br.com.application.name.reports.Query;
import br.com.application.name.reports.model.TestData;
import cucumber.api.Scenario;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Generate the test evidence in PDF file
 *
 */
public class GenerateEvidenceReport {

	/**
	 * Generate evidence in PDF file. The evidence will be save on home dir on a
	 * folder called by the name of the project
	 * 
	 * @param list
	 *            list of evidence made of an text and image
	 * @param reportName
	 *            report name
	 * @param exception
	 *            exception text that are throwing by Java
	 * @throws IOException
	 *             if occurs any problem with the directory
	 */
	@Deprecated
	public static void generatePDFEvidence(List<SeleniumEvidence> list, String reportName, String tester,
			String project, String exception) throws IOException {
		List<SeleniumEvidence> data = list;

		Properties properties = SeleniumEvidenceUtils.loadProperties();
		String evidenceDir = System.getProperty("user.dir") + System.getProperty("file.separator")
				+ properties.getProperty("evidence.dir") + System.getProperty("file.separator");

		createEvidenceDir(evidenceDir);

		try {

			String companyImage = properties.getProperty("image.company.path");
			String customerImage = properties.getProperty("image.customer.path");

			BufferedImage imageCompany;
			BufferedImage imageClient;

			if (companyImage == null || companyImage.equals("null")) {
				imageCompany = null;
			} else {
				imageCompany = ImageIO.read(new File(companyImage));
			}

			if (customerImage == null || customerImage.equals("null")) {
				imageClient = null;
			} else {
				imageClient = ImageIO.read(new File(customerImage));
			}

			if (reportName == null) {
				reportName = "";
			}

			if (tester == null) {
				tester = "";
			}

			if (project == null) {
				project = "";
			}

			if (exception == null) {
				exception = "";
			}

			Map<String, Object> parameters = new HashMap<String, Object>();
			if (exception != null) {
				parameters.put("SEL_EXCEPTION", exception);
			}

			parameters.put("SEL_COMPANY_LOGO", imageCompany);
			parameters.put("SEL_CUSTOMER_LOGO", imageClient);
			parameters.put("SEL_PROJECT", project);
			parameters.put("SEL_TESTER", tester);

			parameters.put("SEL_LABEL_EVINDENCE_TITLE", properties.getProperty("label.evidenceReport"));
			parameters.put("SEL_LABEL_PROJECT", properties.getProperty("label.projetc"));
			parameters.put("SEL_LABEL_TESTER", properties.getProperty("label.tester"));
			parameters.put("SEL_LABEL_STATUS", properties.getProperty("label.status"));
			parameters.put("SEL_LABEL_PASS", properties.getProperty("label.status.pass"));
			parameters.put("SEL_LABEL_FAILED", properties.getProperty("label.status.failed"));
			parameters.put("SEL_LABEL_EVIDENCE_REPORT", properties.getProperty("label.evidenceReport"));
			parameters.put("SEL_LABEL_DATE", properties.getProperty("label.date"));
			parameters.put("SEL_LABEL_FOOTER", properties.getProperty("label.footer"));
			parameters.put("SEL_LABEL_ERROR_DETAIL", properties.getProperty("label.errorDetail"));
			parameters.put("SEL_LABEL_PAGE", properties.getProperty("label.page"));
			parameters.put("SEL_LABEL_COMPANY_NAME", properties.getProperty("label.company.name"));

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(data);
			JasperReport jasperReport = JasperCompileManager.compileReport(properties.getProperty("evidence.file"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);

			JasperExportManager.exportReportToPdfFile(jasperPrint, evidenceDir + reportName + ".pdf");

		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (JRException jre) {
			jre.printStackTrace();
		}
	}

	/**
	 * Generate an evidence report based on EvidenceType (DOC, PDF, HTML)
	 * 
	 * @param evidenceReport
	 *            and EvidenceReport object with basic informations
	 * @param reportType
	 *            filetype
	 * @throws IOException
	 *             if any problem with the files (jasper, EvidenceType) or directory
	 *             occurs
	 */

	public static void generareEvidenceReport(EvidenceReport evidenceReport, EvidenceType reportType, Scenario scenario)
			throws IOException {

		List<SeleniumEvidence> data = evidenceReport.getEvidenceList();

		Properties properties = SeleniumEvidenceUtils.loadProperties();
		String evidenceDir = null;

		switch (scenario.getStatus()) {
		case "passed":
			evidenceDir = System.getProperty("user.dir") + System.getProperty("file.separator")
					+ properties.getProperty("evidence.dir") + System.getProperty("file.separator")
					+ properties.getProperty("passed.dir") + System.getProperty("file.separator");
			break;
		case "failed":
			evidenceDir = System.getProperty("user.dir") + System.getProperty("file.separator")
					+ properties.getProperty("evidence.dir") + System.getProperty("file.separator")
					+ properties.getProperty("failed.dir") + System.getProperty("file.separator");
			break;
		case "null":
			evidenceDir = System.getProperty("user.dir") + System.getProperty("file.separator")
					+ properties.getProperty("evidence.dir") + System.getProperty("file.separator")
					+ properties.getProperty("falha.dir") + System.getProperty("file.separator");
			break;

		default:
			break;

		}

		createEvidenceDir(evidenceDir);

		try {

			String companyImage = properties.getProperty("image.company.path");
			String customerImage = properties.getProperty("image.customer.path");

			BufferedImage imageCompany;
			BufferedImage imageClient;

			if (companyImage == null || companyImage.equals("null")) {
				imageCompany = null;
			} else {
				imageCompany = ImageIO.read(new File(companyImage));
			}

			if (customerImage == null || customerImage.equals("null")) {
				imageClient = null;
			} else {
				imageClient = ImageIO.read(new File(customerImage));
			}

			String reportName = evidenceReport.getReportName();
			if (reportName == null) {
				reportName = "";
			}

			String tester = evidenceReport.getTester();
			if (tester == null) {
				tester = "";
			}

			String ambiente = evidenceReport.getAmbiente();
			if (ambiente == null) {
				ambiente = "";
			}

			String nomeTeste = evidenceReport.getNomeTeste();
			if (nomeTeste == null) {
				nomeTeste = "";
			}

			String cicloTeste = evidenceReport.getCicloTeste();
			if (cicloTeste == null) {
				cicloTeste = "";
			}

			String project = evidenceReport.getProject();
			if (project == null) {
				project = "";
			}

			String exception = evidenceReport.getExceptionString();
			if (exception == null) {
				exception = "";
			}

			Map<String, Object> parameters = new HashMap<String, Object>();
			if (exception != null) {
				parameters.put("SEL_EXCEPTION", exception);
			}

			parameters.put("SEL_COMPANY_LOGO", imageCompany);
			parameters.put("SEL_CUSTOMER_LOGO", imageClient);
			parameters.put("SEL_PROJECT", project);
			parameters.put("SEL_TESTER", tester);
			parameters.put("SEL_AMBIENTE", ambiente);
			parameters.put("SEL_NOMETESTE", nomeTeste);
			parameters.put("SEL_CICLO", cicloTeste);

			parameters.put("SEL_LABEL_EVINDENCE_TITLE", properties.getProperty("label.evidenceReport"));
			parameters.put("SEL_LABEL_NOMETESTE", properties.getProperty("label.nome.teste"));
			parameters.put("SEL_LABEL_CICLO", properties.getProperty("label.ciclo.teste"));
			parameters.put("SEL_LABEL_AMBIENTE", properties.getProperty("label.ambiente"));
			parameters.put("SEL_LABEL_PROJECT", properties.getProperty("label.projetc"));
			parameters.put("SEL_LABEL_TESTER", properties.getProperty("label.tester"));
			parameters.put("SEL_LABEL_STATUS", properties.getProperty("label.status"));
			switch (scenario.getStatus()) {
			case "passed":
				parameters.put("SEL_LABEL_PASS", scenario.getStatus().toLowerCase());
				break;
			case "failed":
				parameters.put("SEL_LABEL_FAILED", scenario.getStatus().toLowerCase());
				break;
			case "null":
				parameters.put("SEL_LABEL_FAILED", "falhou".toLowerCase());
				break;
			default:
				break;
			}
			parameters.put("SEL_LABEL_EVIDENCE_REPORT", properties.getProperty("label.evidenceReport"));
			parameters.put("SEL_LABEL_DATE", properties.getProperty("label.date"));
			parameters.put("SEL_LABEL_FOOTER", properties.getProperty("label.footer"));
			parameters.put("SEL_LABEL_ERROR_DETAIL", properties.getProperty("label.errorDetail"));
			parameters.put("SEL_LABEL_PAGE", properties.getProperty("label.page"));

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(data);

			JasperPrint jasperPrint = JasperFillManager.fillReport(properties.getProperty("evidence.file"), parameters,
					datasource);

			TestData testData = new TestData();
			testData.setProject(project);
			testData.setStepName(scenario.getName());
			testData.setStatus(scenario.getStatus());
			Query.listaTestData.add(testData);
			
			switch (reportType) {
			case PDF:
				JasperExportManager.exportReportToPdfFile(jasperPrint, evidenceDir + reportName + ".pdf");
				break;

			case DOC:
				JRDocxExporter exporter = new JRDocxExporter();
//				SimpleDateFormat horaSistema = new SimpleDateFormat("HH:mm:ss");
//				Date date = new Date();
				ExcelReport.relatorio.add(scenario.getStatus());
				String reportNameDoc = Normalizer.normalize(scenario.getName(), Normalizer.Form.NFD);
				reportNameDoc = reportNameDoc.replaceAll("[^\\p{ASCII}]", "");
				File archivo = new File(evidenceDir + reportNameDoc +".doc");
				FileOutputStream os = new FileOutputStream(archivo);

				exporter.setParameter(JRDocxExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRDocxExporterParameter.CHARACTER_ENCODING, "UTF-8");
				exporter.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, os);

				exporter.exportReport();

				os.close();
				
				break;

			case HTML:
				JasperExportManager.exportReportToHtmlFile(jasperPrint, evidenceDir + reportName + ".html");
				break;

			default:
				break;
			}

		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (JRException jre) {
			jre.printStackTrace();
		}
	}

	/**
	 * Create a directory with the project's name
	 * 
	 * @param project
	 *            project name
	 */
	private static boolean createEvidenceDir(String directory) {
		boolean dirExists = false;

		try {
			File dir = new File(directory);
			boolean exists = dir.exists();

			if (!exists) {
				dir.mkdir();
				dirExists = false;
			} else {
				dirExists = true;
			}
		} catch (SecurityException se) {
			se.printStackTrace();
		}
		return dirExists;
	}
}
