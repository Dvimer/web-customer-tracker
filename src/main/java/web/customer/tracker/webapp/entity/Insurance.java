package web.customer.tracker.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "osago")
public class Insurance
{
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "agent")
	private String agent;
	@Column(name = "offices")
	private String[] offices;
	@Column(name = "location")
	private String location;
	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "start_date_insurance")
	private LocalDate startDateInsurance;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "patronymic")
	private String patronymic;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "insurance_name")
	private String insuranceName;
	@Column(name = "model_auto")
	private String modelAuto;
	@Column(name = "kind_insurance")
	private String kindInsurance;
	@Column(name = "base_rate")
	private BigDecimal baseRate;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "discount")
	private BigDecimal discount;
	@Column(name = "discount_price")
	private BigDecimal discountPrice;
	@Column(name = "delivery")
	private BigDecimal delivery;
	@Column(name = "result_price")
	private BigDecimal resultPrice;
	@Column(name = "kv")
	private BigDecimal kv;
	@Column(name = "kv_summary")
	private BigDecimal kvSummary;
	@Column(name = "dk")
	private String dk;
	@Column(name = "admin_salery")
	private BigDecimal adminSalery;
	@Column(name = "our_summary")
	private BigDecimal ourSummary;
	@Column(name = "cashbox")
	private BigDecimal cashbox;
	@Column(name = "displayed")
	private BigDecimal displayed;
	@Column(name = "displayed_everyone")
	private BigDecimal displayedEveryone;


	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAgent()
	{
		return agent;
	}

	public void setAgent(String agent)
	{
		this.agent = agent;
	}

	public String[] getOffices()
	{
		return offices;
	}

	public void setOffices(String[] offices)
	{
		this.offices = offices;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public LocalDate getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate)
	{
		this.createdDate = createdDate;
	}

	public LocalDate getStartDateInsurance()
	{
		return startDateInsurance;
	}

	public void setStartDateInsurance(LocalDate startDateInsurance)
	{
		this.startDateInsurance = startDateInsurance;
	}


	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getInsuranceName()
	{
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName)
	{
		this.insuranceName = insuranceName;
	}

	public String getModelAuto()
	{
		return modelAuto;
	}

	public void setModelAuto(String modelAuto)
	{
		this.modelAuto = modelAuto;
	}

	public String getKindInsurance()
	{
		return kindInsurance;
	}

	public void setKindInsurance(String kindInsurance)
	{
		this.kindInsurance = kindInsurance;
	}

	public BigDecimal getBaseRate()
	{
		return baseRate;
	}

	public void setBaseRate(BigDecimal baseRate)
	{
		this.baseRate = baseRate;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public BigDecimal getDiscount()
	{
		return discount;
	}

	public void setDiscount(BigDecimal discount)
	{
		this.discount = discount;
	}

	public BigDecimal getDiscountPrice()
	{
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice)
	{
		this.discountPrice = discountPrice;
	}

	public BigDecimal getDelivery()
	{
		return delivery;
	}

	public void setDelivery(BigDecimal delivery)
	{
		this.delivery = delivery;
	}

	public BigDecimal getResultPrice()
	{
		return resultPrice;
	}

	public void setResultPrice(BigDecimal resultPrice)
	{
		this.resultPrice = resultPrice;
	}

	public BigDecimal getKv()
	{
		return kv;
	}

	public void setKv(BigDecimal kv)
	{
		this.kv = kv;
	}

	public BigDecimal getKvSummary()
	{
		return kvSummary;
	}

	public void setKvSummary(BigDecimal kvSummary)
	{
		this.kvSummary = kvSummary;
	}

	public String getDk()
	{
		return dk;
	}

	public void setDk(String dk)
	{
		this.dk = dk;
	}

	public BigDecimal getAdminSalery()
	{
		return adminSalery;
	}

	public void setAdminSalery(BigDecimal adminSalery)
	{
		this.adminSalery = adminSalery;
	}

	public BigDecimal getOurSummary()
	{
		return ourSummary;
	}

	public void setOurSummary(BigDecimal ourSummary)
	{
		this.ourSummary = ourSummary;
	}

	public BigDecimal getCashbox()
	{
		return cashbox;
	}

	public void setCashbox(BigDecimal cashbox)
	{
		this.cashbox = cashbox;
	}

	public BigDecimal getDisplayed()
	{
		return displayed;
	}

	public void setDisplayed(BigDecimal displayed)
	{
		this.displayed = displayed;
	}

	public BigDecimal getDisplayedEveryone()
	{
		return displayedEveryone;
	}

	public void setDisplayedEveryone(BigDecimal displayedEveryone)
	{
		this.displayedEveryone = displayedEveryone;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPatronymic()
	{
		return patronymic;
	}

	public void setPatronymic(String patronymic)
	{
		this.patronymic = patronymic;
	}
}
