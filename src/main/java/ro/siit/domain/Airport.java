package ro.siit.domain;

// javax.persistence e un pachet cu adnotatii si interfete ce tin de JPA
// JPA - Java Persistence API; care e specificatia ce descrie accesul la baza de date
// din aplicatia Java
// accesul e modelat dupa lucrul OOP; modelam tabelele din DB la clase Java, iar coloanele tabelelor
// la proprietati ale claselor => ORM (Object-Relational Mapping)

// JPA e specificatia ce trebuie implementata de biblioteci de clase, cum ar fi Hibernate (by default asta folosim)
// alte implementari, MyBatis, EclipseLink

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

// POJO - plain old Java object
// contine proprietati care vor fi mapate la coloanele tabelei din DB
// fiecare proprietate mapeaza o coloana din tabela "airports"
@Entity
@Table(name = "airports")
public class Airport {

    // cu adnotatiile @Id si @GeneratedValue dam proprietatii id o semnificatie speciala
    // i.e. id va fi identificatorul pentru inregistrarea din DB (PK - primary key)
    // valorile lui vor fi autogenerate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name") // cu ajutorul adnotatiei "@Column" mapam o proprietate a clasei
    // la o coloana din tabela "airports" din DB
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "iata", length = 3) // by default pentru o coloana de tip "string" (in DB e de tip varchar)
    // lungimea e 255 de caractere; dar prin atributul length, am specificat ca numarul de caractere acceptat
    // de coloana e 3
    private String iata;

    @Column(name = "icao", length = 4)
    private String icao;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "altitude")
    private Integer altitude;

    @Column(name = "timezone")
    private Double timezone;

    @Column(name = "dst")
    private Character dst;

    @Column(name = "tz")
    private String tz;

    @Column(name = "type")
    private String type;

    @Column(name = "source")
    private String source;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Double getTimezone() {
        return timezone;
    }

    public void setTimezone(Double timezone) {
        this.timezone = timezone;
    }

    public Character getDst() {
        return dst;
    }

    public void setDst(Character dst) {
        this.dst = dst;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
