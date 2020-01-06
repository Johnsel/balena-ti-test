SUMMARY = "Keyboard configuration database for X Window"

DESCRIPTION = "The non-arch keyboard configuration database for X \
Window.  The goal is to provide the consistent, well-structured, \
frequently released open source of X keyboard configuration data for X \
Window System implementations.  The project is targeted to XKB-based \
systems."

HOMEPAGE = "http://freedesktop.org/wiki/Software/XKeyboardConfig"
BUGTRACKER = "https://bugs.freedesktop.org/enter_bug.cgi?product=xkeyboard-config"

LICENSE = "MIT & MIT-style"
LIC_FILES_CHKSUM = "file://COPYING;md5=0e7f21ca7db975c63467d2e7624a12f9"

SRC_URI = "${XORG_MIRROR}/individual/data/xkeyboard-config/${BPN}-${PV}.tar.bz2"

SRC_URI[md5sum] = "74c4bdf52382127cb5802c3f2ab441e0"
SRC_URI[sha256sum] = "91b18580f46b4e4ea913707f6c8d68ab5286879c3a6591462f3b9e760d3ac4d7"

SECTION = "x11/libs"
DEPENDS = "intltool-native util-macros libxslt-native"

EXTRA_OECONF = "--with-xkb-rules-symlink=xorg --disable-runtime-deps"

FILES_${PN} += "${datadir}/X11/xkb"

inherit autotools pkgconfig gettext

do_install_append () {
    install -d ${D}${datadir}/X11/xkb/compiled
    cd ${D}${datadir}/X11/xkb/rules && ln -sf base xorg
}
