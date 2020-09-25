#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

DEPENDS += "rsync-native"

SRCREV_meson = "61aba373f5708f2aebc3f72078e51949a068aa6f"
LINUX_VERSION = "5.6.19"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-5.6.y;name=meson \
           file://defconfig \
           file://0001-FROMGIT-drm-lima-update-register-info.patch \
           file://0002-arm64-dts-meson-sm1-add-support-for-Hardkernel-ODROI.patch \
           file://0002-FROMGIT-drm-lima-add-lima_vm_map_bo.patch \
           file://0003-FROMGIT-drm-lima-support-heap-buffer-creation.patch \
           file://0004-FROMGIT-drm-lima-recover-task-by-enlarging-heap-buff.patch \
           file://0005-FROMGIT-drm-lima-increase-driver-version-to-1.1.patch \
           file://0006-FROMGIT-drm-lima-fix-recovering-from-PLBU-out-of-mem.patch \
           file://0007-FROMGIT-dt-bindings-reset-meson-add-gxl-internal-dac.patch \
           file://0008-FROMGIT-dt-bindings-clk-meson-add-the-gxl-internal-d.patch \
           file://0009-FROMGIT-clk-meson-gxbb-add-the-gxl-internal-dac-gate.patch \
           file://0010-FROMGIT-clk-meson-gxbb-set-audio-output-clock-hierar.patch \
           file://0011-FROMGIT-ASoC-core-allow-a-dt-node-to-provide-several.patch \
           file://0012-FROMGIT-ASoC-core-ensure-component-names-are-unique.patch \
           file://0013-FROMGIT-ASoC-meson-g12a-extract-codec-to-codec-utils.patch \
           file://0014-FROMGIT-ASoC-meson-aiu-add-audio-output-dt-bindings.patch \
           file://0015-FROMGIT-ASoC-meson-aiu-add-i2s-and-spdif-support.patch \
           file://0016-FROMGIT-ASoC-meson-aiu-add-hdmi-codec-control-suppor.patch \
           file://0017-FROMGIT-ASoC-meson-aiu-add-internal-dac-codec-contro.patch \
           file://0018-FROMGIT-ASoC-meson-axg-extract-sound-card-utils.patch \
           file://0019-FROMGIT-ASoC-meson-gx-add-sound-card-dt-binding-docu.patch \
           file://0020-FROMGIT-ASoC-meson-gx-add-sound-card-support.patch \
           file://0021-FROMGIT-ASoC-meson-aiu-remove-unused-encoder-structu.patch \
           file://0022-FROMGIT-ASoC-meson-aiu-fix-clk-bulk-size-allocation.patch \
           file://0023-FROMGIT-ASoC-meson-aiu-fix-irq-registration.patch \
           file://0024-FROMGIT-ASoC-meson-aiu-fix-acodec-dai-input-name-ini.patch \
           file://0025-FROMGIT-ASoC-meson-codec-glue-fix-pcm-format-cast-wa.patch \
           file://0026-FROMGIT-ASoC-meson-aiu-simplify-component-addition.patch \
           file://0027-FROMGIT-firmware-meson_sm-Add-secure-power-domain-su.patch \
           file://0028-FROMGIT-dt-bindings-power-add-Amlogic-secure-power-d.patch \
           file://0029-FROMGIT-soc-amlogic-Add-support-for-Secure-power-dom.patch \
           file://0030-FROMGIT-arm64-dts-meson-a1-add-secure-power-domain-c.patch \
           file://0031-WIP-clk-meson-g12a-fix-gp0-and-hifi-ranges.patch \
           file://0032-FROMLIST-ASoC-meson-add-t9015-internal-codec-binding.patch \
           file://0033-FROMLIST-ASoC-meson-add-t9015-internal-DAC-driver.patch \
           file://0034-WIP-ASoC-meson-convert-axg-tdm-interface-to-schema.patch \
           file://0035-WIP-ASoC-meson-convert-axg-tdm-formatters-to-schema.patch \
           file://0036-WIP-ASoC-meson-convert-axg-pdm-to-schema.patch \
           file://0037-WIP-ASoC-meson-convert-axg-fifo-to-schema.patch \
           file://0038-WIP-ASoC-meson-convert-axg-spdif-input-to-schema.patch \
           file://0039-WIP-ASoC-meson-convert-axg-spdif-output-to-schema.patch \
           file://0040-WIP-ASoC-meson-convert-g12a-tohdmitx-control-to-sche.patch \
           file://0041-WIP-ASoC-meson-convert-axg-sound-card-control-to-sch.patch \
           file://0042-FROMLIST-ASoC-meson-add-g12a-toacodec-dt-binding-doc.patch \
           file://0043-FROMLIST-ASoC-meson-add-g12-internal-DAC-glue.patch \
           file://0044-FROMLIST-ASoC-meson-axg-card-add-toacodec-support.patch \
           file://0045-FROMLIST-arm64-dts-meson-add-pdm-reset-line.patch \
           file://0047-WIP-arm64-dts-meson-g12a-add-internal-DAC.patch \
           file://0048-WIP-arm64-dts-meson-g12a-add-internal-DAC-glue.patch \
           file://0049-WIP-arm64-dts-meson-gx-add-playback-audio-devices.patch \
           file://0050-WIP-arm64-dts-meson-enable-audio-playback-on-p230-q2.patch \
           file://0051-WIP-arm64-dts-meson-add-audio-playback-to-s905x-p212.patch \
           file://0052-WIP-arm64-dts-meson-add-audio-playback-to-khadas-vim.patch \
           file://0053-WIP-arm64-dts-meson-gxbb-add-playback-audio-devices.patch \
           file://0054-HACK-fix-Kodi-sysinfo-CPU-information.patch \
           file://0055-HACK-media-cec-silence-CEC-timeout-message.patch \
           file://0056-HACK-revert-mm-emit-tracepoint-when-RSS-changes.patch \
           file://0057-HACK-mmc-meson-gx-force-max_segs-max_blk_count-value.patch \
           file://0058-HACK-arm64-dts-meson-gx-add-ATF-BL32-reserved-memory.patch \
           file://0059-HACK-set-meson-gx-cma-pool-to-896MB.patch.disabled \
           file://0060-HACK-set-meson-g12-cma-pool-to-896MB.patch \
           file://0061-FROMLIST-pinctrl-meson-add-missing-tsin-pinctrl-for-.patch \
           file://0062-FROMLIST-doc-dt-bindings-usb-dwc3-Update-entries-for.patch \
           file://0064-FROMLIST-arm64-dts-g12-common-add-parkmode_disable_s.patch \
           file://0065-FROMLIST-dt-bindings-display-bridge-lvds-codec-Add-n.patch \
           file://0066-FROMLIST-drm-meson-vclk-add-support-for-YUV420-setup.patch \
           file://0067-FROMLIST-media-v4l2-mem2mem-handle-draining-stopped-.patch \
           file://0068-FROMLIST-media-vicodec-use-v4l2-mem2mem-draining-sto.patch \
           file://0069-FROMLIST-media-meson-vdec-bring-up-to-compliance.patch \
           file://0070-FROMLIST-media-meson-vdec-add-H.264-decoding-support.patch \
           file://0071-FROMLIST-media-meson-vdec-align-stride-on-32-bytes.patch \
           file://0072-FROMLIST-media-meson-vdec-add-helpers-for-lossless-f.patch \
           file://0073-FROMLIST-media-meson-vdec-add-common-HEVC-decoder-su.patch \
           file://0074-FROMLIST-media-meson-vdec-add-VP9-input-support.patch \
           file://0075-FROMLIST-media-meson-vdec-add-VP9-decoder-support.patch \
           file://0076-FROMLIST-drm-fourcc-Add-modifier-definitions-for-des.patch \
           file://0077-FROMLIST-drm-meson-add-Amlogic-Video-FBC-registers.patch \
           file://0078-FROMLIST-drm-meson-overlay-setup-overlay-for-Amlogic.patch \
           file://0079-FROMLIST-drm-meson-crtc-handle-commit-of-Amlogic-FBC.patch \
           file://0080-FROMLIST-arm64-dts-meson-gxl-s905x-p212-add-bluetoot.patch \
           file://0081-FROMLIST-arm64-dts-meson-gxl-s905x-khadas-vim-add-th.patch \
           file://0082-FROMLIST-arm64-dts-meson-khadas-vim3-move-model-to-g.patch \
           file://0083-FROMLIST-arm64-dts-meson-g12b-fix-VIM3-audio-card-mo.patch \
           file://0084-WIP-arm64-dts-meson-g12b-khadas-vim3-add-the-Etherne.patch \
           file://0085-WIP-ASoC-meson-add-2-8-channel-constraints.patch \
           file://0086-WIP-arm64-dts-meson-khadas-vim3-fix-missing-i2c3-nod.patch \
           file://0087-WIP-arm64-dts-meson-khadas-vim3-change-LED-behaviour.patch \
           file://0088-WIP-arm64-dts-meson-khadas-vim3l-add-audio-playback-.patch \
           file://0091-GX-update-TEXT_OFFSET-for-Amlogic-MESON-SoC.patch \
           file://0093-arm64-dts-VIM1-enable-RTC.patch \
           file://0094-arm64-dts-VIM2-enable-RTC.patch \
           file://0095-arm64-dts-sdio-VIM1-VIM2-change-freq-to-100MHz.patch \
           file://0096-arm64-dts-SDIO-VIM2-enable-cap-sd-highspeed.patch \
           file://0097-arm64-dts-SDIO-VIM3-disable-sd-uhs-sdr50-to-fix-AP63.patch \
           file://0098-arm64-dts-VIMs-add-simple-MCU-driver-for-FAN.patch \
           file://0099-VIM2-add-GPIO-FAN-driver-for-V12-version.patch \
           file://0100-ETH-setup-mac-address-from-command-line.patch \
           file://0101-VIM3-hack-for-PCIe.patch \
           file://0102-WIP-drm-panfrost-add-support-for-custom-soft-reset-on-GXM.patch \
           file://01-10-soc-sunxi-convert-to-devm_platform_ioremap_resource.patch \
           file://0309-arm64-dts-meson-sm1-add-video-decoder-compatible.patch \
           file://0331-ASoC-meson-add-toacodec-dt-bindings.patch \
           file://0346-arm64-dts-meson-u200-add-audio-support.patch \
           file://0350-drm-dw-hdmi-call-hdmi_set_cts_n-after-clock-is-.patch \
           file://0360-arm64-dts-meson-tanix-tx3-add-thermal-zones.patch \
           file://2001-drm-lima-devfreq-and-cooling-device-support.patch \
           file://Add-support-of-CEC-wakeup-on-Amlogic-G12-and-SM1-SoCs.patch \
           file://arm64_01-dts-meson-gx-add-initial-playback-support.patch \
           file://arm64_02-dts-meson-add-internal-audio-DAC-support.patch \
           file://arm64_03-dts-meson-gxbb-add-audio-playback.patch \
           file://arm64-meson-g12-enable-support-for-SPIFC.patch \
           file://board-media-rc-drivers-should-produce-alternate-pulse-and-space-timing-events.patch \
           file://board_nanopi_k2_add_spidev.patch \
           file://board-nanopik2-add-uartC-alias.patch \
           file://board-nanopi_k2_enable_emmc.patch \
           file://board-odroidc2-add-uartA-uartC.patch \
           file://board-odroidc2-enable-scpi-dvfs.patch \
           file://board-odroidc2-enable-SPI.patch \
           file://general-add-configfs-overlay.patch \
           file://general-add-overlay-compilation-support.patch \
           file://general-dwc2-partial-powerdown-fix.patch \
           file://general-kernel-odroidn2-current.patch \
           file://general-meson64-i2cX-missing-pins.patch \
           file://general-meson64-overlays.patch \
           file://linux-5.5-net-smsc95xx-allow-mac-address-as-param.patch \
           file://meson64_remove_spidev_warning.patch \
           file://x-0147-si2168-fix-cmd-timeout.patch \
           file://z-nanopi-k2-ethernet-fix.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

require linux-meson.inc

# Checksum changed on 5.6
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

