package com.eaw1805.data.dto.converters;


import com.eaw1805.data.dto.web.GameSettingsDTO;
import com.eaw1805.data.model.GameSettings;

public final class GameSettingsConverter {

    private GameSettingsConverter() {
        // do nothing
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static GameSettingsDTO convert(final GameSettings value) {

        final GameSettingsDTO settingsDTO = new GameSettingsDTO();
        settingsDTO.setId(value.getGameSettingsId());
        settingsDTO.setGrid(value.isGrid());
        settingsDTO.setLandForces(value.isLandForces());
        settingsDTO.setMovements(value.isMovements());
        settingsDTO.setNavalForces(value.isNavalForces());
        settingsDTO.setPoliticalBorders(value.isPoliticalBorders());
        settingsDTO.setPopulationDensity(value.isPopulationDensity());
        settingsDTO.setSphereOfInfluence(value.isSphereOfInfluence());
        settingsDTO.setVirtualReportedUnits(value.isReportedUnits());
        settingsDTO.setMusic(value.isPlayMusic());
        settingsDTO.setSoundEffects(value.isPlaySoundEffects());
        settingsDTO.setLowResolution(value.isLowResolution());
        settingsDTO.setZoom(value.getZoom());
        settingsDTO.setTradeCities(value.isTradeCities());
        settingsDTO.setFullscreen(value.isFullScreen());
        return settingsDTO;
    }

}
