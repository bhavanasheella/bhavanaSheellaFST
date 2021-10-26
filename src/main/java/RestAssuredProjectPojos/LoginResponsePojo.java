package RestAssuredProjectPojos;

public class LoginResponsePojo {

	private LogindataPojo data;

	private String success;

	private String[] error;

	public LogindataPojo getData() {
		return data;
	}

	public void setData(LogindataPojo data) {
		this.data = data;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String[] getError() {
		return error;
	}

	public void setError(String[] error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ClassPojo [data = " + data + ", success = " + success + ", error = " + error + "]";
	}
}
