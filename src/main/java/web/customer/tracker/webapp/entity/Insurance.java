package web.customer.tracker.webapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

@Entity
@Table(name = "osago")
public class Insurance
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "agent")
	private String agent;
	@Column(name = "offices")
	private String[] offices;
	@Column(name = "location")
	private String location;
	@Column(name = "created_date")
	private String  createdDate;
	@Column(name = "start_date_insurance")
	private String startDateInsurance;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@NotNull
	@Column(name = "insurance_name")
	private String insuranceName;
	@Column(name = "model_auto")
	@NotNull
	private String modelAuto;
	@Column(name = "kind_insurance")
	private String kindInsurance;
	@Column(name = "base_rate")
	private BigDecimal baseRate;
	@Column(name = "price")
	private BigDecimal price;
	// TODO: 3/26/19 добавить поле с величиной скидки в процентах
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


	public String getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getStartDateInsurance()
	{
		return startDateInsurance;
	}

	public void setStartDateInsurance(String startDateInsurance)
	{
		this.startDateInsurance = startDateInsurance;
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

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("Insurance{");
		sb.append("id=").append(id);
		sb.append(", agent='").append(agent).append('\'');
		sb.append(", offices=").append(Arrays.toString(offices));
		sb.append(", location='").append(location).append('\'');
		sb.append(", createdDate=").append(createdDate);
		sb.append(", startDateInsurance=").append(startDateInsurance);
		sb.append(", customer=").append(customer);
		sb.append(", insuranceName='").append(insuranceName).append('\'');
		sb.append(", modelAuto='").append(modelAuto).append('\'');
		sb.append(", kindInsurance='").append(kindInsurance).append('\'');
		sb.append(", baseRate=").append(baseRate);
		sb.append(", price=").append(price);
		sb.append(", discount=").append(discount);
		sb.append(", discountPrice=").append(discountPrice);
		sb.append(", delivery=").append(delivery);
		sb.append(", resultPrice=").append(resultPrice);
		sb.append(", kv=").append(kv);
		sb.append(", kvSummary=").append(kvSummary);
		sb.append(", dk='").append(dk).append('\'');
		sb.append(", adminSalery=").append(adminSalery);
		sb.append(", ourSummary=").append(ourSummary);
		sb.append(", cashbox=").append(cashbox);
		sb.append(", displayed=").append(displayed);
		sb.append(", displayedEveryone=").append(displayedEveryone);
		sb.append('}');
		return sb.toString();
	}
}
