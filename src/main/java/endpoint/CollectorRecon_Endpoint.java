package endpoint;
//enum is special class in java which has collection of constants or  methods
public enum CollectorRecon_Endpoint {

	CollectorRecon_API("/api/v1/collector_recon");

	private String resource;

	CollectorRecon_Endpoint(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}