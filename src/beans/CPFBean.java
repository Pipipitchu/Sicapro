package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CPFBean {

	private String maskCpf;
	private String tipoCpf = "";
	private boolean disabled = Boolean.TRUE;
	
	public void mudaCpf(){
		disabled = Boolean.FALSE;
		if(tipoCpf.equals("fisica")){
			maskCpf = "999.999.999-99";
		}else{
			maskCpf = "99.999.999/9999-99";
		}
	}
	
	public String getMaskCpf() {
		return maskCpf;
	}
	public void setMaskCpf(String maskCpf) {
		this.maskCpf = maskCpf;
	}
	public String getTipoCpf() {
		return tipoCpf;
	}
	public void setTipoCpf(String tipoCpf) {
		this.tipoCpf = tipoCpf;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean redered) {
		this.disabled = redered;
	}

}
