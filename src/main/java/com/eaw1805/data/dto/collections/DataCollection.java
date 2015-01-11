package com.eaw1805.data.dto.collections;

import com.eaw1805.data.dto.common.NationDTO;
import com.eaw1805.data.dto.common.NaturalResourceDTO;
import com.eaw1805.data.dto.common.ProductionSiteDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataCollection
        implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private Map<Integer, NationDTO> nationsMap = new HashMap<Integer, NationDTO>();

    private Map<String, NationDTO> nationsNameMap = new HashMap<String, NationDTO>();

    private Map<Character, NationDTO> nationsCodeMap = new HashMap<Character, NationDTO>();

    private List<NationDTO> nations = new ArrayList<NationDTO>();

    private List<NaturalResourceDTO> natResources = new ArrayList<NaturalResourceDTO>();

    /**
     * A list containing all the available production sites.
     */
    private  List<ProductionSiteDTO> prodSitesList = new ArrayList<ProductionSiteDTO>();

    private Map<Integer, ProductionSiteDTO> prodSites = new HashMap<Integer, ProductionSiteDTO>();

    public DataCollection() {
        super();
    }

    public List<NationDTO> getNations() {
        return nations;
    }

    public void setNations(final List<NationDTO> value) {
        nations = value;
        for (final NationDTO nationDTO : value) {
            nationsMap.put(nationDTO.getNationId(), nationDTO);
            nationsCodeMap.put(nationDTO.getCode(), nationDTO);
            nationsNameMap.put(nationDTO.getName(), nationDTO);
        }
    }

    public NationDTO getNationById(final int nationId) {
        if (nationsMap.containsKey(nationId)) {
            return nationsMap.get(nationId);
        }
        return null;
    }

    public String getNameByNationId(final int nationId) {
        if (nationsMap.containsKey(nationId)) {
            return nationsMap.get(nationId).getName();
        }
        return "";
    }

    public NationDTO getNationByCode(final char nationCode) {
        if (nationsCodeMap.containsKey(nationCode)) {
            return nationsCodeMap.get(nationCode);
        }
        return null;
    }

    public NationDTO getNationByName(final String nationName) {
        if (nationsNameMap.containsKey(nationName)) {
            return nationsNameMap.get(nationName);
        }
        return null;
    }

    public List<NaturalResourceDTO> getNatResources() {
        return natResources;
    }

    public void setNatResources(final List<NaturalResourceDTO> value) {
        this.natResources = value;
    }

    public ProductionSiteDTO getProdSite(final int prodSiteId) {
        return prodSites.get(prodSiteId);
    }

    public void setProdSites(final List<ProductionSiteDTO> value) {
        prodSitesList = value;
        for (final ProductionSiteDTO siteDTO : value) {
            prodSites.put(siteDTO.getId(), siteDTO);
        }
    }

    public List<ProductionSiteDTO> getProdSitesList() {
        return prodSitesList;
    }

}
