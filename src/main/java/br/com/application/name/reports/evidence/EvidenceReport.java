package br.com.application.name.reports.evidence;

import java.util.List;


public class EvidenceReport {

	private List<SeleniumEvidence> evidenceList = null;
	private String reportName = null;
	private String tester = null;
	private String project = null;
	private String exceptionString = null;
	private String ambiente = null;
	private String nomeTeste = null;
	private String cicloTeste = null;

	
	public EvidenceReport(List<SeleniumEvidence> evidenceList, String reportName, String executor,
			String projeto, String exceptionString, String ambiente, String nomeTeste, String cicloTeste) {
		this.evidenceList = evidenceList;
		this.reportName = reportName;
		this.tester = executor;
		this.project = projeto;
		this.exceptionString = exceptionString;
		this.ambiente = ambiente;
		this.nomeTeste = nomeTeste;
		this.cicloTeste = cicloTeste;



	}
	
	/**
	 * @return the evidenceList
	 */
	public List<SeleniumEvidence> getEvidenceList() {
		return evidenceList;
	}
	
	/**
	 * @param evidenceList the evidenceList to set
	 */
	public void setEvidenceList(List<SeleniumEvidence> evidenceList) {
		this.evidenceList = evidenceList;
	}
	
	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}
	
	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	
	public String getTester() {
		return tester;
	}
	
	public void setTester(String tester) {
		this.tester = tester;
	}
	
	public String getAmbiente() {
		return ambiente;
	}
	
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getNomeTeste() {
		return nomeTeste;
	}
	
	public void setNomeTeste(String nomeTeste) {
		this.nomeTeste = nomeTeste;
	}


		
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}
	
	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}
	
	/**
	 * @return the exceptionString
	 */
	public String getExceptionString() {
		return exceptionString;
	}
	
	/**
	 * @param exceptionString the exceptionString to set
	 */
	public void setExceptionString(String exceptionString) {
		this.exceptionString = exceptionString;
	}
	
	
	public String getCicloTeste() {
		return cicloTeste;
	}
	
	public void setCicloTeste(String cicloTeste) {
		this.cicloTeste = cicloTeste;
	}

	
	
}
