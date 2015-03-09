# 2015-03-07
SRCREV_cargo = "b27cd4706063510640410540c1e68da3a294ab24"
SRCREV_rust-installer = "60fd8abfcae50629a3fc664bd809238fed039617"

require cargo.inc

SRC_URI += " \
	git://github.com/carllerche/curl-rust.git;protocol=https;destsuffix=curl-rust;name=curl-rust \
	file://curl-rust/0001-curl-sys-avoid-explicitly-linking-in-openssl.-If-it-.patch;patchdir=../curl-rust \
	file://curl-rust/0002-remove-per-triple-deps-on-openssl-sys.patch;patchdir=../curl-rust \
\
	git://github.com/alexcrichton/ssh2-rs.git;protocol=https;name=ssh2-rs;destsuffix=ssh2-rs \
	file://ssh2-rs/0001-Unconditionally-depend-on-openssl-sys.patch;patchdir=../ssh2-rs \
\
	git://github.com/alexcrichton/git2-rs.git;protocol=https;name=git2-rs;destsuffix=git2-rs \
	file://git2-rs/0001-Add-generic-openssl-sys-dep.patch;patchdir=../git2-rs \
\
\
	git://github.com/alexcrichton/curl.git;protocol=https;destsuffix=curl-rust/curl-sys/curl;name=curl;branch=configure \
	git://github.com/alexcrichton/libgit2.git;protocol=https;destsuffix=git2-rs/libgit2-sys/libgit2;name=libgit2;branch=libgit2-2014-12-19 \
"

# 0.2.1  / -sys 0.1.14
SRCREV_curl-rust = "e05dcfa59813f2d8c443afa3e37e26482e41091b"

# 0.1.11 / -sys 0.1.8
SRCREV_ssh2-rs = "bb0c71792799d7261ae6356a26aabd39c9e78430"

# 0.2.2 / -sys 0.2.1
SRCREV_git2-rs = "8b52e3c86cec585038513116654d308f101e4582"

SRCREV_FORMAT .= "_curl-rust_curl_ssh2-rs_git2-rs"
EXTRA_OECARGO_PATHS = "\
	${WORKDIR}/curl-rust \
	${WORKDIR}/ssh2-rs \
	${WORKDIR}/git2-rs \
"

# FIXME: we don't actually use these, and shouldn't need to fetch it, but not having it results in:
## target/snapshot/bin/cargo build --target x86_64-linux  --verbose 
## Failed to resolve path '/home/cody/obj/y/tmp/work/x86_64-linux/cargo-native/git+gitAUTOINC+0b84923203_9181ea8f4e_8baa8ccb39-r0/curl-rust/curl-sys/curl/.git': No such file or directory
SRCREV_curl = "ac30e9a7746c8641f4871e59b831ec28530c5c73"
SRCREV_libgit2 = "3b48f7f30c271ec9569f722215ee55cc5e922242"
